package com.instantor.plugin

import org.apache.ivy.core.module.descriptor._
import org.apache.ivy.core.module.id.ModuleRevisionId
import org.apache.ivy.core.resolve.ResolveOptions
import org.apache.ivy.core.settings.IvySettings
import org.apache.ivy.Ivy
import org.apache.ivy.plugins.resolver.{ DependencyResolver, IBiblioResolver }
import sbt.MavenRepository

object RevisionResolver extends InstantorRepositories {
  def resolveLatestPluginVersion() =
    resolveLatestVersion(
        repo         = InstantorReleases,
        scalaVersion = "2.10",
        sbtVersion   = "0.13",
        groupId      = "com.instantor",
        artifactId   = "sbt-instantor-plugin")


  def resolveLatestVersion(repo: MavenRepository, scalaVersion: String, sbtVersion: String, groupId: String, artifactId: String): String = {
    val pattern = s"[organisation]/[module]_${ scalaVersion }_${ sbtVersion }/[revision]/[artifact]-[revision](-[classifier]).[ext]"
    val version = "latest.release";

    val resolver = getResolver(repo.name, repo.root, pattern)
    val ivy = getIvy(resolver)
    val resolveOptions = getResolveOptions
    val moduleDescriptor = getModuleDescriptor(groupId, artifactId, version)

    val resolveReport = ivy.resolve(moduleDescriptor, resolveOptions)
    if (resolveReport.hasError) {
        throw new RuntimeException(resolveReport.getAllProblemMessages.toString)
    }

    resolveReport
      .getArtifacts().get(0).asInstanceOf[MDArtifact]
      .getId
      .getModuleRevisionId
      .getRevision
  }


  private def getResolver(name: String, root: String, pattern: String): DependencyResolver = {
    val resolver = new IBiblioResolver
    resolver.setM2compatible(true)
    resolver.setUsepoms(true)
    resolver.setName(name)
    resolver.setRoot(root)
    resolver.setPattern(pattern)
    resolver
  }

  private def getIvy(resolver: DependencyResolver): Ivy = {
    val ivySettings = new IvySettings
    ivySettings.addResolver(resolver)
    ivySettings.setDefaultResolver(resolver.getName)
//    ivySettings.l
    Ivy.newInstance(ivySettings)
  }

  private def getResolveOptions(): ResolveOptions = {
    val resolveOptions = new ResolveOptions
    resolveOptions.setTransitive(true)
    resolveOptions.setDownload(false)
    resolveOptions.setLog("quiet")
    resolveOptions
  }

  private def getModuleDescriptor(groupId: String, artifactId: String, version: String): ModuleDescriptor = {
    val envelopeRevisionId = ModuleRevisionId.newInstance(groupId, artifactId + "-envelope", version)
    val revisionId         = ModuleRevisionId.newInstance(groupId, artifactId, version)

    val moduleDescriptor      = DefaultModuleDescriptor.newDefaultInstance(envelopeRevisionId)
    val dependencydescriptor = new DefaultDependencyDescriptor(moduleDescriptor, revisionId, false, false, false)

    dependencydescriptor.addDependencyConfiguration("default", "master")
    moduleDescriptor.addDependency(dependencydescriptor)
    moduleDescriptor
  }
}
