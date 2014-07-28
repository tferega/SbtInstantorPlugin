package com.instantor.plugin

import sbt._
import Keys._

trait RevisionSettings {
  private val logger = ConsoleLogger()

  lazy val revisionSettings: Seq[Setting[_]] = Seq(
    // We want to do the check on SBT startup
    onLoad := {
      val currentVersion = RevisionResolver.getCurrentPluginVersion
      val latestVersion  = RevisionResolver.resolveLatestPluginVersion

      if (currentVersion != latestVersion) {
        logger.warn(s"Current plugin version differs from latest published version: $currentVersion != $latestVersion")
      }

      onLoad.value
    }
  )
}
