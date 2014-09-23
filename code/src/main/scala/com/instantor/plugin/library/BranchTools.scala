package com.instantor.plugin
package library

import sbt._

import utils.SbtLoggerWrapper

import com.instantor.props.{ PropsLoaderFactory, PropsResolver }
import java.io.File

class BranchTools(logger: Logger) {
  private val propsLoaderFactory = PropsLoaderFactory.init(new SbtLoggerWrapper(logger))
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

  def propsResolver(projectName: String) = {
    propsLoaderFactory.loadBranch(projectName)
  }

  def credentials(propsResolver: PropsResolver): Seq[Credentials] = {
    val credentialsFile = propsResolver.resolve("nexus").toFile()

    if (credentialsFile.exists()) {
      logger.info(s"Credentials file: $credentialsFile")
      val creds = Credentials(credentialsFile)
      Seq(creds)
    } else {
      Seq.empty
    }
  }
}
