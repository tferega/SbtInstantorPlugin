net.virtualvoid.sbt.graph.Plugin.graphSettings

sbtPlugin := true

name := "sbt-branch-loader"

organization := "com.instantor"

scalaVersion := "2.10.4"

version := "0.0.1-SNAPSHOT"

unmanagedSourceDirectories in Compile := (scalaSource in Compile).value :: Nil

unmanagedSourceDirectories in Test := Nil

scalacOptions := Seq(
  "-deprecation",
  "-encoding", "UTF-8",
  "-feature",
  "-language:higherKinds",
  "-language:implicitConversions",
  "-language:postfixOps",
  "-optimise",
  "-unchecked",
  "-Xcheckinit",
  "-Xlint",
  "-Xno-uescape",
  "-Xverify",
  "-Yclosure-elim",
  "-Ydead-code",
  "-Yinline"
)

libraryDependencies += "com.ferega.props" %% "propsloader-scalaapi" % "0.0.1"
