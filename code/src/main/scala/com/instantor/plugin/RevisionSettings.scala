package com.instantor.plugin

import sbt._
import Keys._

class RevisionReporter(logger: Logger) {
  lazy val report: Unit = {
    val currentVersion = RevisionResolver.getCurrentPluginVersion
    val latestVersion  = RevisionResolver.resolveLatestPluginVersion

    if (currentVersion != latestVersion) {
      logger.warn(s"Current plugin version differs from latest published version: $currentVersion != $latestVersion")
    }
  }
}

trait RevisionSettings {
  private val reporter = new RevisionReporter(ConsoleLogger())

  lazy val revisionSettings: Seq[Setting[_]] = Seq(
    // We want to do the check on SBT startup
    onLoad := {
      reporter.report
      onLoad.value
    }
  )
}
