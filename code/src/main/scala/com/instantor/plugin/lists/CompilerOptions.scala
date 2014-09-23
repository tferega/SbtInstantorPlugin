package com.instantor.plugin
package lists

object CompilerOptions {
  val javacOptions = Seq(
      "-deprecation"
    , "-encoding", "UTF-8"
    , "-Xlint:all"
  )

  val scalacOptions_211 = Seq(
      "-deprecation"
    , "-encoding", "UTF-8"
    , "-feature"
    , "-language:existentials"
    , "-language:implicitConversions"
    , "-language:postfixOps"
    , "-language:reflectiveCalls"
    , "-optimise"
    , "-unchecked"
    , "-Xcheckinit"
    , "-Xlint"
    , "-Xmax-classfile-name", "72"
    , "-Xno-forwarders"
    , "-Xverify"
    , "-Yclosure-elim"
    , "-Yconst-opt"
    , "-Ydead-code"
    , "-Yinline-warnings"
    , "-Yinline"
    , "-Yrepl-sync"
    , "-Ywarn-adapted-args"
    , "-Ywarn-dead-code"
    , "-Ywarn-inaccessible"
    , "-Ywarn-infer-any"
    , "-Ywarn-nullary-override"
    , "-Ywarn-nullary-unit"
    , "-Ywarn-numeric-widen"
    , "-Ywarn-unused"
  )

  val scalacOptions_210 = Seq(
      "-deprecation"
    , "-encoding", "UTF-8"
    , "-feature"
    , "-language:existentials"
    , "-language:implicitConversions"
    , "-language:postfixOps"
    , "-language:reflectiveCalls"
    , "-optimise"
    , "-unchecked"
    , "-Xcheckinit"
    , "-Xlint"
    , "-Xmax-classfile-name", "72"
    , "-Xno-forwarders"
    , "-Xverify"
    , "-Yclosure-elim"
    , "-Ydead-code"
    , "-Yinline-warnings"
    , "-Yinline"
    , "-Yrepl-sync"
    , "-Ywarn-adapted-args"
    , "-Ywarn-dead-code"
    , "-Ywarn-inaccessible"
    , "-Ywarn-nullary-override"
    , "-Ywarn-nullary-unit"
    , "-Ywarn-numeric-widen"
  )

  val scalacOptions_209 = Seq(
      "-deprecation"
    , "-encoding", "UTF-8"
    , "-optimise"
    , "-unchecked"
    , "-Xcheckinit"
    , "-Xmax-classfile-name", "72"
    , "-Xno-forwarders"
    , "-Yclosure-elim"
    , "-Ydead-code"
    , "-Yinline"
    , "-Ywarn-dead-code"
  )
}
