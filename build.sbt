import sbtcrossproject.CrossPlugin.autoImport.{crossProject, CrossType}

val sharedSettings = Seq(
  scalaVersion := "2.13.2",
  name := "TigerPython Parser",
  version := "1.0",
  libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.8",
  libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % "test"
)

lazy val tpParser = 
  crossProject(JSPlatform, JVMPlatform)
    .crossType(CrossType.Full)
    .settings(sharedSettings)
    .jsSettings(
      libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.9.8",
      // scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.ESModule) }
    )
    .jvmSettings()

