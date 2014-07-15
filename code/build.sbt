instantorSettings

sbtPlugin := true

name := "SBT Instantor Plugin"

organization := "com.instantor"

version := "0.2.0"

unmanagedSourceDirectories in Compile := (scalaSource in Compile).value :: Nil

unmanagedSourceDirectories in Test := Nil

libraryDependencies += "com.ferega.props" %% "propsloader-scalaapi" % "0.0.2"

publishTo := Some(if (version.value endsWith "-SNAPSHOT") InstantorSnapshots else InstantorReleases)

addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "2.5.0")

addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.7.4")
