package com.instantor.plugin
package utils

import sbt._

import library.IvyRevisionResolver
import lists.InstantorRepositories

class RevisionResolver(logger: Logger) extends InstantorRepositories {
  lazy val report: Unit = {
    val currentVersion = getCurrentPluginVersion
    val latestVersion  = resolveLatestPluginVersion

    if (currentVersion != latestVersion) {
      logger.warn(s"Current plugin version differs from latest published version: $currentVersion != $latestVersion")
    }
  }

  lazy val getCurrentPluginVersion =
    try {
      val props = new java.util.Properties
      props.load(getClass.getResourceAsStream("version.props"))
      props.getProperty("version")
    } catch {
      case e: Exception =>
        throw new IllegalArgumentException(s"An error occurred while loading current plugin version!", e)
    }

  lazy val resolveLatestPluginVersion =
    try {
      IvyRevisionResolver.resolveLatestVersion(
        repoName     = InstantorReleases.name
      , repoRoot     = InstantorReleases.root
      , scalaVersion = "2.10"
      , sbtVersion   = "0.13"
      , groupId      = "com.instantor"
      , artifactId   = "sbt-instantor-plugin"
      )
    } catch {
      case e: Exception =>
        throw new IllegalArgumentException(s"An error occured while finding latest published version of plugin!", e)
    }
}
