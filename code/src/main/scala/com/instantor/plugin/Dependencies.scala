package com.instantor.plugin

import sbt._
import Keys._

trait Dependencies {
  val akkaActor   = "com.typesafe.akka" %% "akka-actor"   % "2.3.4"
  val akkaRemote  = "com.typesafe.akka" %% "akka-remote"  % "2.3.4"
  val akkaCluster = "com.typesafe.akka" %% "akka-cluster" % "2.3.4"

  val commonsCodec = "commons-codec"      % "commons-codec" % "1.9"
  val commonsIo    = "commons-io"         % "commons-io"    % "2.4"
  val commonsLang  = "org.apache.commons" % "commons-lang3" % "3.3.2"

  val dispatchCore = "net.databinder.dispatch" %% "dispatch-core" % "0.11.1"
  val dispatchHttp = "net.databinder"          %% "dispatch-http" % "0.11.1"

  val dslClient = "com.dslplatform" % "dsl-client-http-apache" % "0.4.15"

  val jetty   = "org.eclipse.jetty" % "jetty-webapp" % "9.2.2.v20140723" % "container"
  val servlet = "javax.servlet" % "javax.servlet-api" % "3.0.1" % "provided"

  val jodaTime    = "joda-time" % "joda-time"    % "2.3"
  val jodaConvert = "org.joda"  % "joda-convert" % "1.6"

  val jsoup = "org.jsoup" % "jsoup" % "1.7.3"

  val junit          = "junit" % "junit" % "4.11" % "test"
  val junitInterface = "com.novocode" % "junit-interface" % "0.11-RC1" % "test"

  val liftCommon = "net.liftweb" %% "lift-common" % "2.6-M4"
  val liftJson   = "net.liftweb" %% "lift-json"   % "2.6-M4"
  val liftUtil   = "net.liftweb" %% "lift-util"   % "2.6-M4"
  val liftWebkit = "net.liftweb" %% "lift-webkit" % "2.6-M4"

  val logback = "ch.qos.logback" % "logback-classic" % "1.1.2"

  val lrl = "hr.element.lrl" % "last-resort-loader" % "0.0.2"

  val ngsAkka       = "hr.ngs" %% "ngs-akka"       % "0.4.1-M1"
  val ngsClient     = "hr.ngs" %% "ngs-client"     % "0.4.1-M1"
  val ngsCore       = "hr.ngs" %% "ngs-core"       % "0.4.1-M1"
  val ngsInterfaces = "hr.ngs" %% "ngs-interfaces" % "0.4.1-M1"
  val ngsUtil       = "hr.ngs" %% "ngs-util"       % "0.4.1-M1"

  val propsLoaderApi  = "com.instantor.props" %  "propsloader-api"  % "0.3.4"
  val propsLoaderCore = "com.instantor.props" %  "propsloader-core" % "0.3.4"

  val selenate  = "net.selenate" % "selenate-client" % "0.2.16"

  val scalaIoCore = "com.github.scala-incubator.io" %% "scala-io-core" % "0.4.3"
  val scalaIoFile = "com.github.scala-incubator.io" %% "scala-io-file" % "0.4.3"

  val scalaTest = "org.scalatest" %% "scalatest" % "2.2.0" % "test"

  val scalaTime = "com.github.nscala-time" %% "nscala-time" % "1.2.0"

  val scalaUuid = "io.jvm" %% "scala-uuid" % "0.1.3"

  val slf4j = "org.slf4j" % "slf4j-api" % "1.7.7"

  val xstream   = "com.thoughtworks.xstream" % "xstream" % "1.4.7"
}
