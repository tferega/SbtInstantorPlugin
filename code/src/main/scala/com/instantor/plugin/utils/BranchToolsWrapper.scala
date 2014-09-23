package com.instantor.plugin
package utils

import sbt._

import library.BranchTools

import com.instantor.commons.Memoize1
import com.instantor.props.PropsResolver

class BranchToolsWrapper(logger: Logger) {
  private val bt = new BranchTools(logger)

  val topProjectName = bt.topProjectName _
  val propsResolver  = Memoize1(bt.propsResolver)
  val credentials    = Memoize1(bt.credentials)
}
