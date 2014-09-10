package com.instantor.plugin

import sbt._
import Keys._

import lists.CompilerOptions

import com.typesafe.sbteclipse.plugin.EclipsePlugin.{ EclipseKeys, EclipseProjectFlavor }
import org.sbtidea.SbtIdeaPlugin

trait CompilerSettings extends CompilerOptions {
  lazy val compilerSettings: Seq[Setting[_]] = Seq(
    crossScalaVersions := Seq("2.10.4")
  , scalaVersion := crossScalaVersions.value.head

  , javacOptions := javaOptions_all

  , scalacOptions := (
      scalaVersion.value match {
        case x if x startsWith "2.11" => scalaOptions_211
        case x if x startsWith "2.10" => scalaOptions_210
        case x if x startsWith "2.9"  => scalaOptions_209
        case x => sys.error("Unsupported Scala version: " + x)
      }
    )

  , EclipseKeys.projectFlavor := EclipseProjectFlavor.Scala
  , EclipseKeys.eclipseOutput := Some(".target")

  , SbtIdeaPlugin.ideaExcludeFolders := Seq(".idea", ".idea_modules", ".settings")
  )

  lazy val javaSettings: Seq[Setting[_]] = Seq(
    autoScalaLibrary          := false
  , crossPaths                := false

  , unmanagedSourceDirectories in Compile := Seq((javaSource in Compile).value)
  , unmanagedSourceDirectories in Test    := Seq((javaSource in Test).value)

  , EclipseKeys.projectFlavor := EclipseProjectFlavor.Java
  )
}
