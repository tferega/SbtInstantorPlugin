import sbt._
import Keys._

object InnerSandbox extends Build {
  lazy val root = Project(
      id = "inner-sandbox",
      base = file(".")
  ) dependsOn(RootProject(file("../../code")))
}
