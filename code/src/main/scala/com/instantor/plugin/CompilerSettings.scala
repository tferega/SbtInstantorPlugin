package com.instantor.plugin

import sbt._
import Keys._

import com.instantor.commons.plugin. { CompilerOptions => CO }

import com.typesafe.sbteclipse.plugin.EclipsePlugin.{ EclipseKeys, EclipseProjectFlavor }
import org.sbtidea.SbtIdeaPlugin

trait CompilerSettings {
  lazy val compilerSettings: Seq[Setting[_]] = Seq(
    crossScalaVersions := Seq("2.10.4")
  , scalaVersion := crossScalaVersions.value.head

  , javacOptions := CO.javacOptions

  , scalacOptions := (
      scalaVersion.value match {
        case x if x startsWith "2.11" => CO.scalacOptions_211
        case x if x startsWith "2.10" => CO.scalacOptions_210
        case x if x startsWith "2.9"  => CO.scalacOptions_209
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
