package com.instantor.plugin

import sbt._
import Keys._

trait InstantorRepositories {
  val InstantorNexus            = "Instantor Nexus"             at "http://www.instantor.com/nexus/content/groups/public/"
  val InstantorReleases         = "Instantor Releases"          at "http://www.instantor.com/nexus/content/repositories/releases/"
  val InstantorSnapshots        = "Instantor Snapshots"         at "http://www.instantor.com/nexus/content/repositories/snapshots/"
  val InstantorPrivateReleases  = "Instantor Private Releases"  at "http://www.instantor.com/nexus/content/repositories/releases-private/"
  val InstantorPrivateSnapshots = "Instantor Private Snapshots" at "http://www.instantor.com/nexus/content/repositories/snapshots-private/"
  val InstantorBspReleases      = "Instantor BSP Releases"      at "http://www.instantor.com/nexus/content/repositories/bsp-releases/"
  val InstantorBspSnapshots     = "Instantor BSP Snapshots"     at "http://www.instantor.com/nexus/content/repositories/bsp-snapshots/"
}

trait ResolverSettings
    extends InstantorRepositories {

  lazy val resolverSettings: Seq[Setting[_]] = Seq(
    resolvers := Seq(
      InstantorNexus
    , InstantorPrivateReleases
    , InstantorPrivateSnapshots
    , InstantorBspReleases
    , InstantorBspSnapshots
    )
  , externalResolvers := Resolver.withDefaultResolvers(
      resolvers.value
    , mavenCentral = false
    )
  )
}
