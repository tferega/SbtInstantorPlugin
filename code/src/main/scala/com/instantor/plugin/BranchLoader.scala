package com.instantor.plugin

import java.io.File
import sbt.richFile

class BranchLoader(logger: sbt.Logger) {
  def branchName(key: String): Option[String] = {
    val branchOpt = sys.props.get(key)

    branchOpt match {
      case Some(branch) =>
        logger.info(s"""Detected branch: $branch""")
      case None =>
        logger.info("Not using a branch")
    }

    branchOpt
  }

  def branchFolder(baseFolder:String, branchNameOpt: Option[String]): String =
    branchNameOpt.map(baseFolder + "_" + _).getOrElse(baseFolder)

  def configPath(configHome: File, branchFolder: String, configFilename: String): File = {
    val path = configHome / branchFolder / configFilename
    logger.info(s"Config path: ${ path.getCanonicalPath }")
    path
  }
}
