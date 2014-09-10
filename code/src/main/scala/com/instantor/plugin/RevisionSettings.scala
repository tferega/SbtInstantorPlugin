package com.instantor.plugin

import sbt._
import Keys._

import utils.RevisionResolver

trait RevisionSettings {
  private val reporter = new RevisionResolver(ConsoleLogger())

  // We want to do the check on SBT startup
  lazy val revisionSettings: Seq[Setting[_]] = Seq(
    onLoad := {
      reporter.report
      onLoad.value
    }
  )
}
