package com.instantor.plugin

import sbt._
import Keys._

import com.instantor.props._
import org.slf4j._

object BranchResolver {
  private val logger = LoggerFactory.getLogger("SbtInstantorPlugin")
  private val propsLoaderFactory = PropsLoaderFactory.init(logger)

  def topProjectName(name: String) = {
    val tpn = name
      .replaceFirst("-.*", "") // kill everything after first hyphen
      .replaceAll("\\s+", "")   // kill all whitespaces

    tpn match {
      case tpn if tpn != name =>
        logger.info(s"Top project name $tpn inferred from project name $name")
      case _ =>
        logger.info(s"Top project name: $name")
    }

    tpn
  }

  def propsResolver(projectName: String) =
    propsLoaderFactory.loadBranch(projectName)

  def credentials(propsResolver: PropsResolver): Option[Credentials] = {
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
  val topProjectName     = SettingKey[String]("top-project-name")
  val projectCredentials = SettingKey[Seq[Credentials]]("project-credentials")
  val propsResolver      = SettingKey[PropsResolver]("props-resolver")

  lazy val branchSettings: Seq[Setting[_]] = Seq(
    topProjectName     := BranchResolver.topProjectName(name.value),
    propsResolver      := BranchResolver.propsResolver(topProjectName.value),
    projectCredentials := BranchResolver.credentials(propsResolver.value).toList
  )
}
