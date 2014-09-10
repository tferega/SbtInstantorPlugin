package com.instantor.plugin

import sbt._
import Keys._

import utils.BranchToolsWrapper

import com.instantor.commons.Memoize1
import com.instantor.commons.plugin.BranchTools
import com.instantor.props.PropsResolver

trait BranchSettings {
  private val branchTools = new BranchToolsWrapper(ConsoleLogger())

  val topProjectName     = SettingKey[String]("top-project-name")
  val projectCredentials = SettingKey[Seq[Credentials]]("project-credentials")
  val propsResolver      = SettingKey[PropsResolver]("props-resolver")

  lazy val branchSettings: Seq[Setting[_]] = Seq(
    topProjectName     := branchTools.topProjectName(name.value),
    propsResolver      := branchTools.propsResolver(topProjectName.value),
    projectCredentials := branchTools.credentials(propsResolver.value)
  )
}
