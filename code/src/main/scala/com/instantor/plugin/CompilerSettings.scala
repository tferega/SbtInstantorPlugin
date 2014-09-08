package com.instantor.plugin

import sbt._
import Keys._

import com.typesafe.sbteclipse.plugin.EclipsePlugin._
import org.sbtidea.SbtIdeaPlugin._

trait CompilerSettings {
  lazy val compilerSettings: Seq[Setting[_]] = Seq(
    crossScalaVersions := Seq("2.10.4")
  , scalaVersion := crossScalaVersions.value.head

  , javacOptions := Seq(
      "-deprecation"
    , "-encoding", "UTF-8"
    , "-Xlint:all"
    )

  , scalacOptions := (
      scalaVersion.value match {
        case x if x startsWith "2.11" => Seq(
            "-deprecation"
          , "-encoding", "UTF-8"
          , "-feature"
          , "-language:existentials"
          , "-language:implicitConversions"
          , "-language:postfixOps"
          , "-language:reflectiveCalls"
          , "-optimise"
          , "-unchecked"
          , "-Xcheckinit"
          , "-Xlint"
          , "-Xmax-classfile-name", "72"
          , "-Xno-forwarders"
          , "-Xverify"
          , "-Yclosure-elim"
          , "-Yconst-opt"
          , "-Ydead-code"
          , "-Yinline-warnings"
          , "-Yinline"
          , "-Yrepl-sync"
          , "-Ywarn-adapted-args"
          , "-Ywarn-dead-code"
          , "-Ywarn-inaccessible"
          , "-Ywarn-infer-any"
          , "-Ywarn-nullary-override"
          , "-Ywarn-nullary-unit"
          , "-Ywarn-numeric-widen"
          , "-Ywarn-unused"
          )

        case x if x startsWith "2.10" => Seq(
            "-deprecation"
          , "-encoding", "UTF-8"
          , "-feature"
          , "-language:existentials"
          , "-language:implicitConversions"
          , "-language:postfixOps"
          , "-language:reflectiveCalls"
          , "-optimise"
          , "-unchecked"
          , "-Xcheckinit"
          , "-Xlint"
          , "-Xmax-classfile-name", "72"
          , "-Xno-forwarders"
          , "-Xverify"
          , "-Yclosure-elim"
          , "-Ydead-code"
          , "-Yinline-warnings"
          , "-Yinline"
          , "-Yrepl-sync"
          , "-Ywarn-adapted-args"
          , "-Ywarn-dead-code"
          , "-Ywarn-inaccessible"
          , "-Ywarn-nullary-override"
          , "-Ywarn-nullary-unit"
          , "-Ywarn-numeric-widen"
          )

        case x if x startsWith "2.9" => Seq(
            "-deprecation"
          , "-encoding", "UTF-8"
          , "-optimise"
          , "-unchecked"
          , "-Xcheckinit"
          , "-Xmax-classfile-name", "72"
          , "-Xno-forwarders"
          , "-Yclosure-elim"
          , "-Ydead-code"
          , "-Yinline"
          , "-Ywarn-dead-code"
          )

        case x =>
          sys.error("Unsupported Scala version: " + x)
      }
    )

  , EclipseKeys.projectFlavor := EclipseProjectFlavor.Scala
  , EclipseKeys.eclipseOutput := Some(".target")

  , ideaExcludeFolders := Seq(".idea", ".idea_modules")
  )

  lazy val javaSettings: Seq[Setting[_]] = Seq(
    autoScalaLibrary          := false
  , crossPaths                := false

  , unmanagedSourceDirectories in Compile := Seq((javaSource in Compile).value)
  , unmanagedSourceDirectories in Test    := Seq((javaSource in Test).value)

  , EclipseKeys.projectFlavor := EclipseProjectFlavor.Java
  )
}
