instantorSettings

releaseSettings

sbtPlugin := true

name := "Sbt Instantor Plugin"

organization := "com.instantor"

version := "0.3.15"

unmanagedSourceDirectories in Compile := (scalaSource in Compile).value :: Nil

unmanagedSourceDirectories in Test := Nil

EclipseKeys.createSrc := EclipseCreateSrc.Default + EclipseCreateSrc.Resource

publishTo := Some(if (version.value endsWith "-SNAPSHOT") InstantorSnapshots else InstantorReleases)

libraryDependencies ++= Seq(
  propsLoaderCore,
  logback,
  "org.apache.ivy" % "ivy" % "2.4.0-rc1")

ReleaseKeys.versionFile := file("code") / "src" / "resources" / "version.sbt"

addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "2.5.0")

addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.7.4")
