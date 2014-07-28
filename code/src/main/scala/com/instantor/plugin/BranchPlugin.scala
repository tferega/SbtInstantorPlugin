package com.instantor.plugin

import sbt._
import Keys._

import com.instantor.props.PropsLoader

trait BranchPlugin {
  val projectName        = SettingKey[String]("project-name")
  val projectCredentials = SettingKey[Seq[Credentials]]("project-credentials")
  val propsLoader        = SettingKey[PropsLoader]("props-loader")

  lazy val branchSettings: Seq[Setting[_]] = Seq(
      projectName        := BranchLoader.topProjectName(name.value),
      propsLoader        := BranchLoader.propsLoader(projectName.value),
      projectCredentials := BranchLoader.credentials(propsLoader.value)
  )
}
