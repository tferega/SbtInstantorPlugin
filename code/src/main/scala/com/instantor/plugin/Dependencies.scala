package com.instantor.plugin

import sbt._
import Keys._

trait Dependencies {
  val akkaVersion = "2.1.1"
  val akkaActor   = "com.typesafe.akka" %% "akka-actor"   % akkaVersion
  val akkaCluster = "com.typesafe.akka" %% "akka-cluster" % akkaVersion
  val akkaRemote  = "com.typesafe.akka" %% "akka-remote"  % akkaVersion
  val akkaAll     = Seq(akkaActor, akkaCluster, akkaRemote)

  val commonsCodecVersion = "1.9"
  val commonsIoVersion    = "2.4"
  val commonsLangVersion  = "3.3.2"
  val commonsCodec        = "commons-codec"      % "commons-codec" % commonsCodecVersion
  val commonsIo           = "commons-io"         % "commons-io"    % commonsIoVersion
  val commonsLang         = "org.apache.commons" % "commons-lang3" % commonsLangVersion
  val commonsAll          = Seq(commonsCodec, commonsIo, commonsLang)

  val dispatchVersion = "0.11.1"
  val dispatchCore    = "net.databinder.dispatch" %% "dispatch-core" % dispatchVersion
  val dispatchHttp    = "net.databinder"          %% "dispatch-http" % dispatchVersion
  val dispatchAll     = Seq(dispatchCore, dispatchHttp)

  val dslClientVersion = "0.1.15"
  val dslClient        = "com.dslplatform" % "dsl-client-http-apache" % dslClientVersion

  val jetty = Seq(
      "org.eclipse.jetty" % "jetty-webapp" % "9.2.1.v20140609" % "container"
    , "org.eclipse.jetty.orbit" % "javax.servlet" % "3.0.0.v201112011016" % "container" artifacts Artifact("javax.servlet", "jar", "jar")
  )

  val jodaTimeVersion    = "2.3"
  val jodaConvertVersion = "1.6"
  val jodaTime           = "joda-time" % "joda-time"    % jodaTimeVersion
  val jodaConvert        = "org.joda"  % "joda-convert" % jodaConvertVersion
  val jodaAll            = Seq(jodaTime, jodaConvert)

  val jsoupVersion = "1.7.3"
  val jsoup        = "org.jsoup" % "jsoup" % jsoupVersion

  val junitVersion = "4.11"
  val junit        = "junit" % "junit" % junitVersion

  val liftVersion = "2.6-M4"
  val liftCommon = "net.liftweb" %% "lift-common" % liftVersion
  val liftJson   = "net.liftweb" %% "lift-json"   % liftVersion
  val liftUtil   = "net.liftweb" %% "lift-util"   % liftVersion
  val liftWebkit = "net.liftweb" %% "lift-webkit" % liftVersion
  val liftAll     = Seq(liftCommon, liftJson, liftUtil, liftWebkit)

  val lrlVersion = "0.0.2"
  val lrl        = "hr.element.lrl" % "last-resort-loader" % lrlVersion

  val ngsVersion    = "0.4.1-M1"
  val ngsAkka       = "hr.ngs" %% "ngs-akka"       % ngsVersion
  val ngsClient     = "hr.ngs" %% "ngs-client"     % ngsVersion
  val ngsCore       = "hr.ngs" %% "ngs-core"       % ngsVersion
  val ngsInterfaces = "hr.ngs" %% "ngs-interfaces" % ngsVersion
  val ngsUtil       = "hr.ngs" %% "ngs-util"       % ngsVersion
  val ngsAll        = Seq(ngsAkka, ngsClient, ngsCore, ngsInterfaces, ngsUtil)

  val propsLoaderVersion = "0.1.1"
  val propsLoaderJava  = "com.instantor.props" %  "propsloader-javaapi"  % propsLoaderVersion
  val propsLoaderScala = "com.instantor.props" %  "propsloader-scalaapi" % propsLoaderVersion
  val propsLoaderAll   = Seq(propsLoaderJava, propsLoaderScala)

  val selenateVersion = "0.2.16"
  val selenate        = "net.selenate" % "selenate-client" % selenateVersion

  val scalaIoVersion = "0.4.3"
  val scalaIoCore    = "com.github.scala-incubator.io" %% "scala-io-core" % scalaIoVersion
  val scalaIoFile    = "com.github.scala-incubator.io" %% "scala-io-file" % scalaIoVersion
  val scalaIoAll     = Seq(scalaIoCore, scalaIoFile)

  val scalaTestVersion = "2.2.0"
  val scalaTest        = "org.scalatest" %% "scalatest" % scalaTestVersion

  val scalaTimeVersion = "0.4.2"
  val scalaTime        = "com.github.nscala-time" %% "nscala-time" % scalaTimeVersion

  val scalaUuidVersion = "0.1.3"
  val scalaUuid        = "io.jvm" %% "scala-uuid" % scalaUuidVersion

  val xstreamVersion = "1.4.7"
  val xstream        = "com.thoughtworks.xstream" % "xstream" % xstreamVersion
}
