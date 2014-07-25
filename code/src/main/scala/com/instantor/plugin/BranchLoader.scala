package com.instantor.plugin

import com.instantor.props.{ PropsLoader, PropsLoaderFactory }
import org.slf4j.LoggerFactory
import sbt.Credentials

object BranchLoader {
  private val logger = LoggerFactory.getLogger(BranchLoader.getClass())
  private val plFactory = PropsLoaderFactory.init(logger)

  def topProjectName(name: String) = {
    val topProjectName =
      if (name.contains('-')) {
        val loc = name.indexOf('-')
        name.substring(0, loc)
      } else {
        name
      }
      .replaceAll("""[\s\W_]""", "")  // Remove spaces and all weird characters.

    logger.info(s"Top project name $topProjectName inferred from project name $name")
    topProjectName
  }

  def propsLoader(projectName: String) =
    plFactory.loadBranch(projectName)

  def credentials(pl: PropsLoader): Seq[Credentials] = {
    val configFile = pl.resolve("nexus").toFile()
    val credentialsFile =
      if (configFile.exists) {
        Seq(configFile)
      } else {
        Seq.empty
      }
    logger.info(s"Credentials file: $credentialsFile")
    credentialsFile map Credentials.apply
  }
}
