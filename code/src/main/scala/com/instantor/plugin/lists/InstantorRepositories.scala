package com.instantor.plugin
package lists

import sbt._

trait InstantorRepositories {
  val InstantorNexus            = "Instantor Nexus"             at "http://www.instantor.com/nexus/content/groups/public/"
  val InstantorReleases         = "Instantor Releases"          at "http://www.instantor.com/nexus/content/repositories/releases/"
  val InstantorSnapshots        = "Instantor Snapshots"         at "http://www.instantor.com/nexus/content/repositories/snapshots/"
  val InstantorPrivateReleases  = "Instantor Private Releases"  at "http://www.instantor.com/nexus/content/repositories/releases-private/"
  val InstantorPrivateSnapshots = "Instantor Private Snapshots" at "http://www.instantor.com/nexus/content/repositories/snapshots-private/"
  val InstantorBspReleases      = "Instantor BSP Releases"      at "http://www.instantor.com/nexus/content/repositories/bsp-releases/"
  val InstantorBspSnapshots     = "Instantor BSP Snapshots"     at "http://www.instantor.com/nexus/content/repositories/bsp-snapshots/"
}
