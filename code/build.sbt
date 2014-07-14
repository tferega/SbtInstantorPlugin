branchSettings

sbtPlugin := true

name := "SBT Instantor Plugin"

organization := "com.instantor"

scalaVersion := "2.10.4"

version := "0.1.2"

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

libraryDependencies += "com.ferega.props" %% "propsloader-scalaapi" % "0.0.2"

publishTo := Some(InstantorReleases)

credentials += Credentials(configPath.value)

publishArtifact in (Compile, packageSrc) := false

publishArtifact in (Compile, packageDoc) := false

addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "2.5.0")

addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.7.4")
