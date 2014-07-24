instantorSettings

sbtPlugin := true

name := "SBT Instantor Plugin"

organization := "com.instantor"

version := "0.3.0"

unmanagedSourceDirectories in Compile := (scalaSource in Compile).value :: Nil

unmanagedSourceDirectories in Test := Nil

publishTo := Some(if (version.value endsWith "-SNAPSHOT") InstantorSnapshots else InstantorReleases)

libraryDependencies ++= Seq(
  "com.instantor.props" % "propsloader-core" % "0.3.0",
  "ch.qos.logback"      % "logback-classic"  % "1.1.2"
)

addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "2.5.0")

addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.7.4")
