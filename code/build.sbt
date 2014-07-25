instantorSettings

sbtPlugin := true

name := "SBT Instantor Plugin"

organization := "com.instantor"

version := "0.3.7-SNAPSHOT"

unmanagedSourceDirectories in Compile := (scalaSource in Compile).value :: Nil

unmanagedSourceDirectories in Test := Nil

publishTo := Some(if (version.value endsWith "-SNAPSHOT") InstantorSnapshots else InstantorReleases)

libraryDependencies ++= Seq(
  propsLoaderCore,
  logback,
  "org.apache.ivy" % "ivy" % "2.4.0-rc1")

addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "2.5.0")

addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.7.4")
