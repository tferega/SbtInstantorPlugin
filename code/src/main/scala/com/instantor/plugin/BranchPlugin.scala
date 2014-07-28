package com.instantor.plugin

import sbt._
import Keys._

import com.instantor.props.PropsResolver

trait BranchPlugin {
  val projectName        = SettingKey[String]("project-name")
  val projectCredentials = SettingKey[Seq[Credentials]]("project-credentials")
  val propsResolver      = SettingKey[PropsResolver]("props-resolver")

  lazy val branchSettings: Seq[Setting[_]] = Seq(
    projectName        := BranchLoader.topProjectName(name.value),
    propsResolver      := BranchLoader.propsResolver(projectName.value),
    projectCredentials := BranchLoader.credentials(propsResolver.value)
  )
}
