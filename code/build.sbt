sbtPlugin := true

name := "Sbt Instantor Plugin"

organization := "com.instantor"

version := "0.3.26"

unmanagedSourceDirectories in Compile := (scalaSource in Compile).value :: Nil

unmanagedSourceDirectories in Test := Nil

EclipseKeys.createSrc := EclipseCreateSrc.Default + EclipseCreateSrc.Resource

publishTo := Some(if (version.value endsWith "-SNAPSHOT") InstantorSnapshots else InstantorReleases)

libraryDependencies ++= Seq(
  commonsIo
, ivy
, logback
, propsLoaderCore
)

ReleaseKeys.versionFile := file("src") / "main" / "resources" / "version.sbt"

addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "2.5.0")

addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.7.4")

addSbtPlugin("com.github.gseitz" % "sbt-release" % "0.8.3")

addSbtPlugin("io.spray" % "sbt-revolver" % "0.7.2")
