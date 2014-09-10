package com.instantor.plugin

import sbt._
import Keys._

import lists.InstantorRepositories

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
