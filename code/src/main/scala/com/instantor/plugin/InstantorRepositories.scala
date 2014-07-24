package com.instantor.plugin

import sbt.toRepositoryName

trait InstantorRepositories {
  val InstantorNexus            = "Instantor Nexus"             at "http://www.instantor.com/nexus/content/groups/public/"
  val InstantorReleases         = "Instantor Releases"          at "http://www.instantor.com/nexus/content/repositories/releases/"
  val InstantorSnapshots        = "Instantor Snapshots"         at "http://www.instantor.com/nexus/content/repositories/snapshots/"
  val InstantorPrivateReleases  = "Instantor Private Releases"  at "http://www.instantor.com/nexus/content/repositories/releases-private/"
  val InstantorPrivateSnapshots = "Instantor Private Snapshots" at "http://www.instantor.com/nexus/content/repositories/snapshots-private/"
  val BSPReleases               = "BSP Releases"                at "http://www.instantor.com/nexus/content/repositories/bsp-releases/"
  val BSPSnapshots              = "BSP Snapshots"               at "http://www.instantor.com/nexus/content/repositories/bsp-snapshots/"
}
