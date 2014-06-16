net.virtualvoid.sbt.graph.Plugin.graphSettings

sbtPlugin := true

name := "sbt-branch-loader"

organization := "com.instantor"

scalaVersion := "2.10.4"

version := "0.0.1"

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

publishTo := Some(
  if (version.value endsWith "SNAPSHOT") {
    "Element Snapshots" at "http://repo.element.hr/nexus/content/repositories/snapshots/"
  }  else {
    "Element Releases" at "http://repo.element.hr/nexus/content/repositories/releases/"
  }
)

credentials += Credentials(Path.userHome / ".config" / "SbtBranchLoader" / "nexus.config")

publishArtifact in (Compile, packageSrc) := false

publishArtifact in (Compile, packageDoc) := false
