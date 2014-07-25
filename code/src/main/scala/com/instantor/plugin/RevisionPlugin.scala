package com.instantor.plugin

import sbt._
import Keys._

import com.instantor.props.PropsLoader

trait RevisionPlugin {
  private val logger = ConsoleLogger()

  lazy val checkRevision = taskKey[Unit]("Checks the plugin current version versus latest published version")

  lazy val revisionSettings: Seq[Setting[_]] = Seq(
    checkRevision := {
      val latestVersion  = RevisionResolver.resolveLatestPluginVersion
      val currentVersion = RevisionResolver.getCurrentPluginVersion
      if (currentVersion != latestVersion) {
        logger.warn(s"Current plugin version differs from latest published version: $currentVersion != $latestVersion")
      }
    }
  )
}
