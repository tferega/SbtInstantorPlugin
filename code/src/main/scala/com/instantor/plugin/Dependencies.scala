package com.instantor.plugin

import sbt._
import Keys._

trait Dependencies {
  val androidSDK = "com.google.android" % "android" % "4.1.1.4" % "provided"

  val akkaActor   = "com.typesafe.akka" %% "akka-actor"   % "2.3.4"
  val akkaCluster = "com.typesafe.akka" %% "akka-cluster" % "2.3.4"
  val akkaRemote  = "com.typesafe.akka" %% "akka-remote"  % "2.3.4"

  val bcMail       = "org.bouncycastle" % "bcmail-jdk16"   % "1.46"
  val bouncyCastle = "org.bouncycastle" % "bcprov-jdk15on" % "1.50"

  val commonsCodec        = "commons-codec"       % "commons-codec"        % "1.9"
  val commonsCollections  = "commons-collections" % "commons-collections"  % "3.2.1"
  val commonsCollections4 = "org.apache.commons"  % "commons-collections4" % "4.0"
  val commonsIo           = "commons-io"          % "commons-io"           % "2.4"
  val commonsLang         = "org.apache.commons"  % "commons-lang3"        % "3.3.2"
  val commonsLogging      = "commons-logging"     % "commons-logging"      % "1.2"

  val configrity = "org.streum" % "configrity-core" % "1.0.0"

  val cssSelectors = "se.fishtank" %% "css-selectors-scala" % "0.1.2"

  val c3p0 = "com.mchange" % "c3p0" % "0.9.2.1"

  val dispatchCore    = "net.databinder.dispatch" %% "dispatch-core" % "0.11.1"
  val dispatchHttp    = "net.databinder"          %% "dispatch-http" % "0.11.1"
  val dispatchClassic = "net.databinder"          %% "dispatch-http" % "0.8.9"

  val doitCsv = "hr.element.doit" %% "doit-csv" % "0.1.7"

  val dslClientHttp = "com.dslplatform" % "dsl-client-http-apache" % "0.4.15"

  val etbUtil = "hr.element.etb" %% "etb-util" % "0.2.20"
  val etbLift = "hr.element.etb" %% "etb-lift" % "0.1.5"
  val etbImg  = "hr.element.etb" %% "etb-img"  % "0.2.1"

  val instantorApi = "com.instantor" % "instantor-api" % "0.4.1"

  val iorc = "org.pgscala" %% "pgscala-iorc" % "0.1.9"

  val itext = "com.itextpdf" % "itextpdf" % "5.5.1"

  val jetty   = "org.eclipse.jetty" % "jetty-webapp"      % "9.2.2.v20140723" % "container"
  val servlet = "javax.servlet"     % "javax.servlet-api" % "3.0.1"           % "provided"

  val jodaTime    = "joda-time" % "joda-time"    % "2.3"
  val jodaConvert = "org.joda"  % "joda-convert" % "1.6"

  val jsch = "com.jcraft" % "jsch" % "0.1.51"

  val jsoup = "org.jsoup" % "jsoup" % "1.7.3"

  val liftCommon = "net.liftweb" %% "lift-common" % "2.6-M4"
  val liftJson   = "net.liftweb" %% "lift-json"   % "2.6-M4"
  val liftUtil   = "net.liftweb" %% "lift-util"   % "2.6-M4"
  val liftWebkit = "net.liftweb" %% "lift-webkit" % "2.6-M4"

  val lrl = "hr.element.lrl" % "last-resort-loader" % "0.0.2"

  val markWrap = "org.clapper" %% "markwrap" % "1.0.2"

  val mimeTypes = "hr.element.onebyseven.common" % "mimetypes" % "2013-10-21"

  val ngsAkka       = "hr.ngs" %% "ngs-akka"       % "0.4.1-M1"
  val ngsClient     = "hr.ngs" %% "ngs-client"     % "0.4.1-M1"
  val ngsCore       = "hr.ngs" %% "ngs-core"       % "0.4.1-M1"
  val ngsInterfaces = "hr.ngs" %% "ngs-interfaces" % "0.4.1-M1"
  val ngsUtil       = "hr.ngs" %% "ngs-util"       % "0.4.1-M1"

  val picoCon = "org.picocontainer" % "picocontainer" % "3.0.a3" classifier "ngs"

  val postgres = "org.postgresql" %  "postgresql"   % "9.3-1102-jdbc41"
  val pgscala  = "org.pgscala"    %% "pgscala"      % "0.7.25"
  val pgpool   = "org.pgscala"    %% "pgscala-pool" % "0.2.18"

  val propsLoaderApi  = "com.instantor.props" %  "propsloader-api"  % "0.3.6"
  val propsLoaderCore = "com.instantor.props" %  "propsloader-core" % "0.3.6"

  val scalaIoCore = "com.github.scala-incubator.io" %% "scala-io-core" % "0.4.3"
  val scalaIoFile = "com.github.scala-incubator.io" %% "scala-io-file" % "0.4.3"

  val scalaTime = "com.github.nscala-time" %% "nscala-time" % "1.2.0"

  val scalaUUID = "io.jvm" %% "scala-uuid" % "0.1.3"

  val scalaz  = "org.scalaz" %% "scalaz-core" % "6.0.4"
  val scalaz7 = "org.scalaz" %% "scalaz-core" % "7.1.0-RC1"

  val selenate  = "net.selenate" % "selenate-client" % "0.2.16"

  val sprayCan       = "io.spray" %% "spray-can"     % "1.3.1"
  val sprayRouting   = "io.spray" %% "spray-routing" % "1.3.1"

  val spyMemcached = "com.google.code.simple-spring-memcached" % "spymemcached" % "2.8.4"

  val templater = "hr.ngs.templater" %% "templater" % "1.9.2-1"

  val xstream   = "com.thoughtworks.xstream" % "xstream" % "1.4.7"

  val zip4j = "net.lingala.zip4j" % "zip4j" % "1.3.1"


  /* Logging */
  val logback = "ch.qos.logback" % "logback-classic" % "1.1.2"

  val scalaLogging = "com.typesafe.scala-logging" %% "scala-logging-slf4j" % "2.1.2"

  val slf4j          = "org.slf4j" % "slf4j-api"        % "1.7.7"
  val log4jOverSlf4j = "org.slf4j" % "log4j-over-slf4j" % "1.7.7"

  val totalogInterface = "com.instantor.totalog" % "totalog-interfaces" % "0.4.2"
  val totalogTransport = "com.instantor.totalog" % "totalog-transport"  % "0.4.2"


  /* Testing  */

  val akkaTestKit = "com.typesafe.akka" %% "akka-testkit" % "2.3.4" % "test"

  val jsonAssert = "org.skyscreamer" % "jsonassert" % "1.2.3" % "test"

  val junit          = "junit"        % "junit"           % "4.11"     % "test"
  val junitInterface = "com.novocode" % "junit-interface" % "0.11-RC1" % "test"

  val scalaTest = "org.scalatest" %% "scalatest" % "2.2.0" % "test"

  val xmlUnit = "xmlunit" % "xmlunit" % "1.5" % "test"
}
