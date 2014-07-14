package com.instantor.branchloader

import sbt._
import Keys._

import com.typesafe.sbteclipse.plugin.EclipsePlugin.{ EclipseKeys, settings => eclipseSettings }
import net.virtualvoid.sbt.graph.Plugin.graphSettings

object InstantorPlugin extends
    Plugin with
    BranchPlugin with
    InstantorRepositories {

  val instantorSettings: Seq[Setting[_]] =
    eclipseSettings ++ graphSettings ++
    branchSettings ++ otherSettings ++ publishingSettings ++ resolverSettings

  // ---------------------------------------------------------------------------

  val publishingSettings: Seq[Setting[_]] = Seq(
    publishTo := Some(
      if (version.value endsWith "SNAPSHOT") {
        InstantorPrivateSnapshots
      } else {
        InstantorPrivateReleases
      }
    ),
    credentials += Credentials(configPath.value)
  )

  val resolverSettings: Seq[Setting[_]] = Seq(
      resolvers := Seq(
        InstantorNexus,
        InstantorPrivateReleases,
        InstantorPrivateSnapshots),
      externalResolvers := Resolver.withDefaultResolvers(resolvers.value, mavenCentral = false)
  )

  val otherSettings: Seq[Setting[_]] = Seq(
      crossScalaVersions := Seq("2.10.4"),
      scalaVersion := crossScalaVersions.value.head,
      scalacOptions := (
        scalaVersion.value match {
          case x if x startsWith "2.11" => Seq(
            "-deprecation",
            "-encoding", "UTF-8",
            "-feature",
            "-language:existentials",
            "-language:implicitConversions",
            "-language:postfixOps",
            "-language:reflectiveCalls",
            "-optimise",
            "-unchecked",
            "-Xcheckinit",
            "-Xlint",
            "-Xmax-classfile-name", "72",
            "-Xno-forwarders",
            "-Xverify",
            "-Yclosure-elim",
            "-Yconst-opt",
            "-Ydead-code",
            "-Yinline-warnings",
            "-Yinline",
            "-Yrepl-sync",
            "-Ywarn-adapted-args",
            "-Ywarn-dead-code",
            "-Ywarn-inaccessible",
            "-Ywarn-infer-any",
            "-Ywarn-nullary-override",
            "-Ywarn-nullary-unit",
            "-Ywarn-numeric-widen",
            "-Ywarn-unused")
          case x if x startsWith "2.10" => Seq(
            "-deprecation",
            "-encoding", "UTF-8",
            "-feature",
            "-language:existentials",
            "-language:implicitConversions",
            "-language:postfixOps",
            "-language:reflectiveCalls",
            "-optimise",
            "-unchecked",
            "-Xcheckinit",
            "-Xlint",
            "-Xmax-classfile-name", "72",
            "-Xno-forwarders",
            "-Xverify",
            "-Yclosure-elim",
            "-Ydead-code",
            "-Yinline-warnings",
            "-Yinline",
            "-Yrepl-sync",
            "-Ywarn-adapted-args",
            "-Ywarn-dead-code",
            "-Ywarn-inaccessible",
            "-Ywarn-nullary-override",
            "-Ywarn-nullary-unit",
            "-Ywarn-numeric-widen")
          case _ => Seq(
            "-deprecation",
            "-encoding", "UTF-8",
            "-optimise",
            "-unchecked",
            "-Xcheckinit",
            "-Xmax-classfile-name", "72",
            "-Xno-forwarders",
            "-Yclosure-elim",
            "-Ydead-code",
            "-Yinline",
            "-Ywarn-dead-code")
        }),
      javacOptions := Seq(
        "-deprecation",
        "-encoding", "UTF-8",
        "-Xlint:unchecked"),
      EclipseKeys.eclipseOutput := Some(".target")
  )
}
