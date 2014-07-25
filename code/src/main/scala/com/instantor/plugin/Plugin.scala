package com.instantor.plugin

import sbt._
import Keys._
import com.typesafe.sbteclipse.plugin.EclipsePlugin.{ EclipseKeys, settings => eclipseSettings }
import net.virtualvoid.sbt.graph.Plugin.graphSettings
import org.apache.ivy.core.settings.IvySettings
import org.apache.ivy.plugins.resolver.IBiblioResolver
import org.apache.ivy.core.resolve.ResolveOptions
import org.apache.ivy.core.module.descriptor.DefaultModuleDescriptor
import org.apache.ivy.core.module.id.ModuleRevisionId
import org.apache.ivy.core.module.descriptor.DefaultDependencyDescriptor
import org.apache.ivy.core.report.ResolveReport
import org.apache.ivy.Ivy
import org.apache.ivy.core.retrieve.RetrieveOptions
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._

object InstantorPlugin extends
    Plugin with
    BranchPlugin with
    InstantorRepositories with
    Dependencies {

  def main(args: Array[String]) {
    val groupId = "com.instantor";
    val artifactId = "sbt-instantor-plugin";
    val sbtVersion = "0.13"
    val scalaVersion = "2.10"
    val version = "latest.integration";
    val out = new File("out");

    // create an ivy instance
    val ivySettings = new IvySettings();
    ivySettings.setDefaultCache(new File("ivy/cache"));

    // use the biblio resolver, if you consider resolving
    // POM declared dependencies
    val br = new IBiblioResolver();
    br.setM2compatible(true);
    br.setUsepoms(true);
    br.setName("instantor");
    br.setRoot(InstantorReleases.root)

    println(br.getPattern)
    sys.exit(0)
    println(br.getRoot + br.getPattern)

    ivySettings.addResolver(br);
    ivySettings.setDefaultResolver(br.getName());

    val ivy = Ivy.newInstance(ivySettings);

    // Step 1: you always need to resolve before you can retrieve
    //
    val ro = new ResolveOptions();
    // this seems to have no impact, if you resolve by module descriptor (in contrast to resolve by ModuleRevisionId)
    ro.setTransitive(true);
    // if set to false, nothing will be downloaded
    ro.setDownload(true);


    // 1st create an ivy module (this always(!) has a "default" configuration already)
    // give it some related name (so it can be cached)
    val md = DefaultModuleDescriptor.newDefaultInstance(ModuleRevisionId.newInstance(groupId, artifactId+"-envelope", version))

    // 2. add dependencies for what we are really looking for
    val ri = ModuleRevisionId.newInstance(groupId, artifactId, version)

    // don't go transitive here, if you want the single artifact
    val dd = new DefaultDependencyDescriptor(md, ri, false, false, false);

    // map to master to just get the code jar. See generated ivy module xmls from maven repo
    // on how configurations are mapped into ivy. Or check
    // e.g. http://lightguard-jp.blogspot.de/2009/04/ivy-configurations-when-pulling-from.html
    dd.addDependencyConfiguration("default", "master");
    md.addDependency(dd);

    // now resolve
    val rr: ResolveReport = ivy.resolve(md,ro);

    if (rr.hasError()) {
        throw new RuntimeException(rr.getAllProblemMessages().toString());
    }

    println(rr.getAllArtifactsReports()(0).getArtifact().getModuleRevisionId().getRevision())

    // Step 2: retrieve
//    val m = rr.getModuleDescriptor();
//
//    ivy.retrieve(
//        m.getModuleRevisionId(),
//        out.getAbsolutePath()+"/[artifact](-[classifier]).[ext]",
//        new RetrieveOptions()
//            // this is from the envelop module
//            .setConfs(Array[String]("default"))
//    );
  }







  lazy val instantorSettings: Seq[Setting[_]] =
    eclipseSettings ++ graphSettings ++
    branchSettings ++ otherSettings ++ publishingSettings ++ resolverSettings

  // ---------------------------------------------------------------------------

  lazy val publishingSettings: Seq[Setting[_]] = Seq(
    publishTo := Some(
      if (version.value endsWith "-SNAPSHOT") {
        InstantorPrivateSnapshots
      } else {
        InstantorPrivateReleases
      }
    ),
    credentials ++= projectCredentials.value,
    publishArtifact in (Compile, packageDoc) := false
  )

  lazy val resolverSettings: Seq[Setting[_]] = Seq(
    resolvers := Seq(
      InstantorNexus,
      InstantorPrivateReleases,
      InstantorPrivateSnapshots,
      BSPSnapshots,
      BSPReleases),
    externalResolvers := Resolver.withDefaultResolvers(resolvers.value, mavenCentral = false)
  )

  lazy val otherSettings: Seq[Setting[_]] = Seq(
    crossScalaVersions := Seq("2.10.4"),
    scalaVersion := crossScalaVersions.value.head,
    scalacOptions := (
      scalaVersion.value match {
        case x if x startsWith "2.11" => Seq(
          "-deprecation",
          "-encoding", "UTF-8",
          "-feature",
          "-language:existentials",
          "-language:implicitConversions",
          "-language:postfixOps",
          "-language:reflectiveCalls",
          "-optimise",
          "-unchecked",
          "-Xcheckinit",
          "-Xlint",
          "-Xmax-classfile-name", "72",
          "-Xno-forwarders",
          "-Xverify",
          "-Yclosure-elim",
          "-Yconst-opt",
          "-Ydead-code",
          "-Yinline-warnings",
          "-Yinline",
          "-Yrepl-sync",
          "-Ywarn-adapted-args",
          "-Ywarn-dead-code",
          "-Ywarn-inaccessible",
          "-Ywarn-infer-any",
          "-Ywarn-nullary-override",
          "-Ywarn-nullary-unit",
          "-Ywarn-numeric-widen",
          "-Ywarn-unused")
        case x if x startsWith "2.10" => Seq(
          "-deprecation",
          "-encoding", "UTF-8",
          "-feature",
          "-language:existentials",
          "-language:implicitConversions",
          "-language:postfixOps",
          "-language:reflectiveCalls",
          "-optimise",
          "-unchecked",
          "-Xcheckinit",
          "-Xlint",
          "-Xmax-classfile-name", "72",
          "-Xno-forwarders",
          "-Xverify",
          "-Yclosure-elim",
          "-Ydead-code",
          "-Yinline-warnings",
          "-Yinline",
          "-Yrepl-sync",
          "-Ywarn-adapted-args",
          "-Ywarn-dead-code",
          "-Ywarn-inaccessible",
          "-Ywarn-nullary-override",
          "-Ywarn-nullary-unit",
          "-Ywarn-numeric-widen")
        case _ => Seq(
          "-deprecation",
          "-encoding", "UTF-8",
          "-optimise",
          "-unchecked",
          "-Xcheckinit",
          "-Xmax-classfile-name", "72",
          "-Xno-forwarders",
          "-Yclosure-elim",
          "-Ydead-code",
          "-Yinline",
          "-Ywarn-dead-code")
      }),
    javacOptions := Seq(
      "-deprecation",
      "-encoding", "UTF-8",
      "-Xlint:unchecked"),
    EclipseKeys.eclipseOutput := Some(".target")
  )
}
