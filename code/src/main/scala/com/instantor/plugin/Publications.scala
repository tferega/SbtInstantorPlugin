package com.instantor.plugin

import sbt._

trait Publications {
  val InstantorApi = "com.instantor" % "instantor-api" % "0.4.1"

  object PropsLoader {
    val Api  = "com.instantor.props" % "propsloader-api"  % "0.3.14"
    val Core = "com.instantor.props" % "propsloader-core" % "0.3.14"
  }

  object TotaLog {
    val Interfaces = "com.instantor.totalog" % "totalog-interfaces" % "0.5.1"
    val Transport  = "com.instantor.totalog" % "totalog-transport"  % "0.5.5"
  }

  object BspClientApi {
    val Model = "com.instantor.bsp" % "bspclientapi-model" % "0.2.0"
  }
}
