SbtBranchLoader
===============

Provides keys for easy configuration loading based on a branch.

To use it, add this line to your plugin definition file.
```scala
// +-------------------------------------------------------------------------------------+
// | Branch Loader SBT plugin (https://github.com/instantor/SbtBranchLoader)             |
// | Provides keys for construction of config folder based on branch (as defined in JVM  |
// | system properties.                                                                  |
// +-------------------------------------------------------------------------------------+

addSbtPlugin("com.instantor" % "sbt-branch-loader" % "0.0.2")
```

Main key SbtBranchLoader provides is `configPath`. It specifies a path to credentials file based on a branch name specified in the System properties.

### Common use case ###

#### .scala ####
```scala
import com.instantor.branchloader.BranchPlugin._
val settings = branchSettings ++ Seq(
  credentials += Credentials(configPath.value)
)
```

#### .sbt ####
```scala
branchSettings

credentials += Credentials(configPath.value)
```
