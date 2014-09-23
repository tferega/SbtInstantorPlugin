import sbt._
import Keys._

import com.instantor.plugin.InstantorPlugin._

trait Default {
  lazy val defaultSettings =
    Defaults.defaultSettings ++
    instantorSettings ++ Seq()
}

object Sandbox extends Build with Default {
  lazy val proj1 = Project(
    "Sandbox-Proj1"
  , file("Proj1")
  , settings = defaultSettings
  )
  
  lazy val proj2 = Project(
    "Sandbox-Proj2"
  , file("Proj2")
  , settings = defaultSettings
  )
}
