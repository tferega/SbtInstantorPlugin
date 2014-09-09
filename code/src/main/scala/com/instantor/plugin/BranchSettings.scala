package com.instantor.plugin

import sbt._
import Keys._

import com.instantor.props._

class BranchResolver(logger: Logger) {
  private val slf4jLogger = new SbtLoggerWrapper(logger)
  private val propsLoaderFactory = PropsLoaderFactory.init(slf4jLogger)

  // This function has to be executed once for each project (so that each
  // project can know the top project name).
  // To keep it from spamming the log, "inferrance" message is trace.
  def topProjectName(name: String) = {
    val tpn = name
      .replaceFirst("-.*", "")  // kill everything after first hyphen
      .replaceAll("\\s+", "")   // kill all whitespace

    tpn match {
      case tpn if tpn != name =>
        logger.debug(s"Top project name $tpn inferred from project name $name")
      case _ =>
        logger.info(s"Top project name: $name")
    }

    tpn
  }

  // "projectName" here is actually top project name. It makes no sense to
  // load the same propsResolver for each sub-project, so the results are
  // cached.
  val propsResolver = Memoize1(propsResolverRaw)
  private def propsResolverRaw(projectName: String) = {
    propsLoaderFactory.loadBranch(projectName)
  }

  // There is only one PropsResover per top-project. It makes no sense to
  // load the came credentials for each sub-project, so the results are
  // cached.
  val credentials = Memoize1(credentialsRaw)
  private def credentialsRaw(propsResolver: PropsResolver): Option[Credentials] = {
    val credentialsFile = propsResolver.resolve("nexus").toFile()

    if (credentialsFile.exists()) {
      logger.info(s"Credentials file: $credentialsFile")
      Some(Credentials(credentialsFile))
    } else {
      None
    }
  }
}

trait BranchSettings {
  private val logger = ConsoleLogger()
  private val branchResolver = new BranchResolver(logger)

  val topProjectName     = SettingKey[String]("top-project-name")
  val projectCredentials = SettingKey[Seq[Credentials]]("project-credentials")
  val propsResolver      = SettingKey[PropsResolver]("props-resolver")

  lazy val branchSettings: Seq[Setting[_]] = Seq(
    topProjectName     := branchResolver.topProjectName(name.value),
    propsResolver      := branchResolver.propsResolver(topProjectName.value),
    projectCredentials := branchResolver.credentials(propsResolver.value).toList
  )
}
