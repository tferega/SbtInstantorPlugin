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

Common use case
---------------

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

#### Detailed documentation ####

###### All keys and their relationships ######

![All keys and their relationships](https://github.com/tferega/SbtBranchLoader/blob/master/doc/SbtBranchLoader%20Key%20Graph.png?raw=true)

###### Key descrptions ######

|     Key Name     |                         Description                   |             Defaults             |
|------------------|-------------------------------------------------------|----------------------------------|
| `branchPrefix`   | A prefix for branchKey.                               | equal to `name`.                 |
| `branchKey`      | A key in System props which contains the branch name. | `branchPrefix + ".branch"`       |
| `branchName`     | Name of the branch, loaded from System properties.    |                                  |
| `baseFolder`     | Project-specific part of `credentialsFolder`.         | equal to `name`.                 |
| `branchFolder`   | Used to construct credentialsPath (third part).       | `baseFolder` OR `baseFolder + "_" + branchName` |
| `configHome`     | Used to construct credentialsPath (first part).       | `Path.userHome`                  |
| `configFolder`   | Used to construct credentialsPath (second part).      | `".config"`                      |
| `configFilename` | Used to construct credentialsPath (fourth part).      | `"nexus.config"`                 |
| `configPath`     | Folder from which to load Credentials.                | `configHome / configFolder / branchFolder / configFilename` |

###### Overriding defaults ######

Any of the defined keys can be overriden, and the changes will propagate.

