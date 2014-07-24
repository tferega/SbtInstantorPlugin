package com.instantor.plugin

import sbt._
import Keys._

trait BranchPlugin {
  val projectName        = SettingKey[String]("project-name")
  val projectCredentials = SettingKey[Seq[Credentials]]("project-credentials")

  lazy val branchSettings: Seq[Setting[_]] = Seq(
      projectName        := BranchLoader.topProjectName(name.value),
      projectCredentials := BranchLoader.credentials(projectName.value)
  )
}
