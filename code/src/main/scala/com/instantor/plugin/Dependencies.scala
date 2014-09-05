package com.instantor.plugin

import sbt._

trait Dependencies {
  val androidSDK = "com.google.android" % "android" % "4.1.1.4" % "provided"

  val akkaActor   = "com.typesafe.akka" %% "akka-actor"   % "2.3.5"
  val akkaCluster = "com.typesafe.akka" %% "akka-cluster" % "2.3.5"
  val akkaRemote  = "com.typesafe.akka" %% "akka-remote"  % "2.3.5"

  val asyncHttpClient = "com.ning" % "async-http-client" % "1.8.13"

  val bouncyCastleMail     = "org.bouncycastle" % "bcmail-jdk15on" % "1.51"
  val bouncyCastleProvider = "org.bouncycastle" % "bcprov-jdk15on" % "1.51"

  val commonsCodec        = "commons-codec"       % "commons-codec"        % "1.9"
  val commonsCollections  = "commons-collections" % "commons-collections"  % "3.2.1"
  val commonsCollections4 = "org.apache.commons"  % "commons-collections4" % "4.0"
  val commonsCsv          = "org.apache.commons"  % "commons-csv"          % "0.1"
  val commonsIo           = "commons-io"          % "commons-io"           % "2.4"
  val commonsLang         = "org.apache.commons"  % "commons-lang3"        % "3.3.2"
  val commonsLogging      = "commons-logging"     % "commons-logging"      % "1.2"

  val configrity = "org.streum" %% "configrity-core" % "1.0.0"

  val cssSelectors = "se.fishtank" %% "css-selectors-scala" % "0.1.2"

  val c3p0 = "com.mchange" % "c3p0" % "0.9.2.1"

  val dispatchCore    = "net.databinder.dispatch" %% "dispatch-core" % "0.11.2"
  val dispatchClassic = "net.databinder"          %% "dispatch-http" % "0.8.10"

  val doitCsv = "hr.element.doit" %% "doit-csv" % "0.1.7"

  val dslClientHttp = "com.dslplatform" % "dsl-client-http-apache" % "0.4.15"

  val etbUtil = "hr.element.etb" %% "etb-util" % "0.2.20"
  val etbLift = "hr.element.etb" %% "etb-lift" % "0.1.5"
  val etbImg  = "hr.element.etb" %% "etb-img"  % "0.2.1"

  val iorc = "org.pgscala" %% "pgscala-iorc" % "0.1.9"

  val itext = "com.itextpdf" % "itextpdf" % "5.5.1"

  val jetty   = "org.eclipse.jetty" % "jetty-webapp"      % "9.2.2.v20140723" % "container"
  val servlet = "javax.servlet"     % "javax.servlet-api" % "3.0.1"           % "provided"

  val ivy = "org.apache.ivy" % "ivy" % "2.4.0-rc1"

  val jodaTime    = "joda-time" % "joda-time"    % "2.4"
  val jodaConvert = "org.joda"  % "joda-convert" % "1.7"

  val jsch = "com.jcraft" % "jsch" % "0.1.51"

  val jsoup = "org.jsoup" % "jsoup" % "1.7.3"

  val liftCommon = "net.liftweb" %% "lift-common" % "2.6-RC1"
  val liftJson   = "net.liftweb" %% "lift-json"   % "2.6-RC1"
  val liftUtil   = "net.liftweb" %% "lift-util"   % "2.6-RC1"
  val liftWebkit = "net.liftweb" %% "lift-webkit" % "2.6-RC1"

  val lrl = "hr.element.lrl" % "last-resort-loader" % "0.0.2"

  val markWrap = "org.clapper" %% "markwrap" % "1.0.2"

  val mimeTypes = "hr.element.onebyseven.common" % "mimetypes" % "2013-10-21"

  val ngsAkka       = "hr.ngs" %% "dsl-server-akka"       % "0.4.1"
  val ngsClient     = "hr.ngs" %% "dsl-server-client"     % "0.4.1"
  val ngsCore       = "hr.ngs" %% "dsl-server-core"       % "0.4.1"
  val ngsInterfaces = "hr.ngs" %% "dsl-server-interfaces" % "0.4.1"
  val ngsUtil       = "hr.ngs" %% "dsl-server-util"       % "0.4.1"

  val openCsv = "net.sf.opencsv" % "opencsv" % "2.3"

  val picoContainer = "org.picocontainer" % "picocontainer" % "3.0.a3" classifier "ngs"

  val postgres = "org.postgresql" %  "postgresql"   % "9.3-1102-jdbc41"
  val pgscala  = "org.pgscala"    %% "pgscala"      % "0.7.29"

  val pgscalaLegacy = "hr.element.pgscala" %% "pgscala-pool-legacy" % "0.1.7-2"

  val rhino = "org.mozilla" % "rhino" % "1.7R4"

  val scalaIoCore = "com.github.scala-incubator.io" %% "scala-io-core" % "0.4.3"
  val scalaIoFile = "com.github.scala-incubator.io" %% "scala-io-file" % "0.4.3"

  val scalaTime = "com.github.nscala-time" %% "nscala-time" % "1.4.0"

  val scalaUUID = "io.jvm" %% "scala-uuid" % "0.1.3"

  val scalaz  = "org.scalaz" %% "scalaz-core" % "6.0.4"
  val scalaz7 = "org.scalaz" %% "scalaz-core" % "7.1.0"

  val selenate  = "net.selenate" % "selenate-client" % "0.2.16"

  val seleniumFirefox = "org.seleniumhq.selenium" % "selenium-firefox-driver" % "2.42.2"
  val seleniumServer  = "org.seleniumhq.selenium" % "selenium-server"         % "2.42.2"

  val sprayCan       = "io.spray" %% "spray-can"     % "1.3.1"
  val sprayRouting   = "io.spray" %% "spray-routing" % "1.3.1"

  val spyMemcached = "net.spy" % "spymemcached" % "2.11.4"

  val squeryl = "org.squeryl" %% "squeryl" % "0.9.5-6"

  val tagSoup = "org.ccil.cowan.tagsoup" % "tagsoup" % "1.2.1"

  val templater = "hr.ngs.templater" %% "templater" % "1.9.4"

  val xstream   = "com.thoughtworks.xstream" % "xstream" % "1.4.7"

  val zip4j = "net.lingala.zip4j" % "zip4j" % "1.3.1"


  /* Logging */
  val akkaSlf4j = "com.typesafe.akka" %% "akka-slf4j" % "2.3.5"

  val logback = "ch.qos.logback" % "logback-classic" % "1.1.2"

  val scalaLogging = "com.typesafe.scala-logging" %% "scala-logging-slf4j" % "2.1.2"

  val slf4jApi       = "org.slf4j" % "slf4j-api"        % "1.7.7"
  val log4jOverSlf4j = "org.slf4j" % "log4j-over-slf4j" % "1.7.7"


  /* Testing  */

  val akkaTestKit = "com.typesafe.akka" %% "akka-testkit" % "2.3.5" % "test"

  val jsonAssert = "org.skyscreamer" % "jsonassert" % "1.2.3" % "test"

  val junit          = "junit"        % "junit"           % "4.11" % "test"
  val junitInterface = "com.novocode" % "junit-interface" % "0.11" % "test"

  val scalaTest = "org.scalatest" %% "scalatest" % "2.2.1" % "test"

  val xmlUnit = "xmlunit" % "xmlunit" % "1.5" % "test"
}
