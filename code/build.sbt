instantorSettings

sbtPlugin := true

name := "Sbt Instantor Plugin"

unmanagedSourceDirectories in Compile := (scalaSource in Compile).value :: Nil

unmanagedSourceDirectories in Test := Nil

EclipseKeys.createSrc := EclipseCreateSrc.Default + EclipseCreateSrc.Resource

publicRelease

libraryDependencies ++= Seq(
  commonsIo
, ivy
, logback
, PropsLoader.Core
, instantorCommonsPlugin
)

addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.7.4")

addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "2.5.0")

addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.6.0")

addSbtPlugin("com.github.gseitz" % "sbt-release" % "0.8.4")

addSbtPlugin("io.spray" % "sbt-revolver" % "0.7.2")

onLoad := {
  val body = "version=%s\ndate=%s" format (version.value, org.joda.time.LocalDate.now)
  val propertiesPath = (
    baseDirectory.value
    / "src" / "main" / "resources"
    / "com" / "instantor" / "plugin" / "utils"
    / "version.props"
  )
  org.apache.commons.io.FileUtils.writeStringToFile(propertiesPath, body, "UTF-8")
  onLoad.value
}
