package com.instantor.branchloader

import sbt._
import Keys._

object BranchPlugin extends Plugin {
  val baseFolder  = SettingKey[String]("base-folder")
  val branch       = SettingKey[Option[String]]("branch")
  val branchFolder = SettingKey[String]("branch-folder")

  private val loader = new BranchLoader(ConsoleLogger())

  val branchSettings: Seq[Setting[_]] = Seq(
      branch       := loader.loadBranch,
      branchFolder <<= (baseFolder, branch)(loader.loadBranchFolder)
  )
}
