package com.instantor.branchloader

import com.ferega.props.sapi._

import java.io.File
import sbt.richFile

class BranchLoader(logger: sbt.Logger) {
  def branchName(key: String): Option[String] = {
    val pl = new PropsLoader(true)
    val branchOpt = pl.opt[String](key)

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
