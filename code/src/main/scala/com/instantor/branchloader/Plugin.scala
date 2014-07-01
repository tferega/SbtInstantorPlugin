package com.instantor.branchloader

import sbt._
import Keys._

object BranchPlugin extends Plugin {
  val branchPrefix    = SettingKey[String]("branch-prefix", "A prefix for branchKey.")
  val branchKey       = SettingKey[String]("branch-key", "A key in System props which contains the branch name.")
  val branchName      = SettingKey[Option[String]]("branch-name", "Name of the branch, loaded from System properties.")
  val baseFolder      = SettingKey[String]("base-folder", "Project-specific part of credentialsFolder.")
  val branchFolder    = SettingKey[String]("branch-folder", "Used to construct credentialsPath (third part).")
  val configHome      = SettingKey[File]("config-home", "Used to construct credentialsPath (first part).")
  val configFolder    = SettingKey[String]("config-folder", "Used to construct credentialsPath (second part).")
  val configFilename  = SettingKey[String]("config-filename", "Used to construct credentialsPath (fourth part).")
  val configPath      = SettingKey[File]("config-path", "Folder from which to load Credentials.")

  private val loader = new BranchLoader(ConsoleLogger())

  val branchSettings: Seq[Setting[_]] = Seq(
      branchPrefix   <<= name,
      branchKey      <<= (branchPrefix)(_ + ".branch"),
      branchName     <<= (branchKey)(loader.branchName),
      baseFolder     <<= name,
      branchFolder   <<= (baseFolder, branchName)(loader.branchFolder),
      configHome     :=  Path.userHome,
      configFolder   :=  ".config",
      configFilename :=  "nexus.config",
      configPath     <<= (configHome, configFolder, branchFolder, configFilename)(loader.configPath)
  )
}
