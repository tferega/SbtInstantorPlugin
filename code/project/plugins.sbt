resolvers := Seq(
  "Instantor Nexus" at "http://www.instantor.com/nexus/content/groups/public/"
, Resolver.url("Instantor Nexus (Ivy)", new URL("http://www.instantor.com/nexus/content/groups/public/"))(Resolver.ivyStylePatterns)
)

externalResolvers := Resolver.withDefaultResolvers(resolvers.value, mavenCentral = false)

// +-------------------------------------------------------------------------------------+
// | SBT Eclipse (https://github.com/typesafehub/sbteclipse)                             |
// | Creates .project and .classpath files for easy Eclipse project imports              |
// |                                                                                     |
// | See also: Eclipse downloads (http://www.eclipse.org/downloads/)                     |
// | See also: Scala IDE downloads (http://download.scala-ide.org/)                      |
// +-------------------------------------------------------------------------------------+

addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "2.5.0")

// +-------------------------------------------------------------------------------------+
// | Dependency graph SBT plugin (https://github.com/jrudolph/sbt-dependency-graph)      |
// | Lists all library dependencies in a nicely formatted way for easy inspection.       |
// +-------------------------------------------------------------------------------------+

addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.7.4")

// +-------------------------------------------------------------------------------------+
// | Branch Loader SBT plugin (https://github.com/instantor/SbtBranchLoader)             |
// | Provides keys for construction of config folder based on branch (as defined in JVM  |
// | system properties.                                                                  |
// +-------------------------------------------------------------------------------------+

addSbtPlugin("com.instantor" % "sbt-branch-loader" % "0.1.0")
