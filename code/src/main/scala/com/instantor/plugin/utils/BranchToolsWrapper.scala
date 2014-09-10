package com.instantor.plugin
package utils

import sbt._

import com.instantor.commons.Memoize1
import com.instantor.commons.plugin.BranchTools
import com.instantor.props.PropsResolver

class BranchToolsWrapper(logger: Logger) {
  private val bt = new BranchTools(new SbtLoggerWrapper(logger))

  val topProjectName = Memoize1(bt.topProjectName)
  val propsResolver  = Memoize1(bt.propsResolver)
  val credentials    = { propsResolver: PropsResolver =>
    Memoize1(bt.credentials)(propsResolver)
        .map(Credentials.apply)
        .toList
  }
}
