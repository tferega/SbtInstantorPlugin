import sbt._
import Keys._

object Sandbox extends Build {
  val plugin = RootProject(file("../../code"))
  lazy val root = Project(
      id = "sandbox",
      base = file(".")
  ).dependsOn(plugin)
}
