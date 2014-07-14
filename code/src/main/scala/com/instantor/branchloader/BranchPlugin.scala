package com.instantor.branchloader

import sbt._
import Keys._

trait BranchPlugin {
  private val loader = new BranchLoader(ConsoleLogger())

  val branchPrefix    = SettingKey[String]("branch-prefix", "A prefix for branchKey.")
  val branchKey       = SettingKey[String]("branch-key", "A key in System props which contains the branch name.")
  val branchName      = SettingKey[Option[String]]("branch-name", "Name of the branch, loaded from System properties.")
  val baseFolder      = SettingKey[String]("base-folder", "Project-specific part of credentialsFolder.")
  val branchFolder    = SettingKey[String]("branch-folder", "Used to construct credentialsPath (third part).")
  val configHome      = SettingKey[File]("config-home", "Used to construct credentialsPath (first part).")
  val configFilename  = SettingKey[String]("config-filename", "Used to construct credentialsPath (fourth part).")
  val configPath      = SettingKey[File]("config-path", "Folder from which to load Credentials.")

  val branchSettings: Seq[Setting[_]] = Seq(
      branchPrefix   := name.value,
      branchKey      := branchPrefix.value + ".branch",
      branchName     := loader.branchName(branchKey.value),
      baseFolder     := name.value,
      branchFolder   := loader.branchFolder(baseFolder.value, branchName.value),
      configHome     := Path.userHome / ".config",
      configFilename := "nexus.config",
      configPath     := loader.configPath(configHome.value, branchFolder.value, configFilename.value)
  )
}
