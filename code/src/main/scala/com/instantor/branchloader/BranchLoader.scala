package com.instantor.branchloader

import com.ferega.props.sapi._

class BranchLoader(logger: sbt.Logger) {
  def loadBranch: Option[String] = {
    val pl = new PropsLoader(true)
    val branchOpt = pl.opt[String]("branch")

    branchOpt match {
      case Some(branch) =>
        logger.info(s"""Detected branch: $branch""")
      case None =>
        logger.warn("""Java property "branch" not defined. To define it use: sbt --jvm "branch=#####"""")
    }

    branchOpt
  }

  def loadBranchFolder(baseFolder:String, branchOpt: Option[String]): String = {
    val folder = branchOpt match {
      case Some(branch) =>
        baseFolder + "_" + branch
      case None =>
        baseFolder
    }
    logger.info(s"""Branch folder: $folder""")
    folder
  }
}
