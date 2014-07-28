package com.instantor.plugin

import sbt._
import Keys._
import com.typesafe.sbteclipse.plugin.EclipsePlugin.eclipseSettings
import net.virtualvoid.sbt.graph.Plugin.graphSettings
import sbtrelease.ReleasePlugin.releaseSettings
import spray.revolver.RevolverPlugin.Revolver.{ settings => revolverSettings }

object InstantorPlugin
    extends Plugin
    with BranchSettings
    with CompilerSettings
    with ResolverSettings
    with RevisionSettings
    with Dependencies {

  // Autoload until ported to extend AutoPlugin
  override lazy val projectSettings =
    instantorSettings

  private lazy val externalPluginSettings: Seq[Setting[_]] =
    eclipseSettings ++
    graphSettings ++
    releaseSettings ++
    revolverSettings

  lazy val instantorSettings: Seq[Setting[_]] =
    externalPluginSettings ++
    branchSettings ++
    compilerSettings ++
    resolverSettings ++
    revisionSettings ++
    publishingSettings ++
    otherSettings

  // ---------------------------------------------------------------------------

  lazy val publishingSettings: Seq[Setting[_]] = Seq(
    publishTo := Some(
      if (version.value endsWith "-SNAPSHOT") {
        InstantorPrivateSnapshots
      } else {
        InstantorPrivateReleases
      }
    )
  , credentials ++= projectCredentials.value
  , publishArtifact in (Compile, packageDoc) := false
  )

  lazy val otherSettings: Seq[Setting[_]] = Seq(
    shellPrompt := { state =>
      "iPlug (%s)> ".format(Project.extract(state).currentProject.id)
    }
  )
}
