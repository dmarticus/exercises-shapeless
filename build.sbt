import com.jsuereth.sbtpgp.PgpKeys.publishSigned

publishLocal := (publishLocal dependsOn compile).value
publishSigned := (publishSigned dependsOn compile).value

addCommandAlias("ci-test", "scalafmtCheckAll; scalafmtSbtCheck; test")
addCommandAlias("ci-docs", "github; project-docs/mdoc; headerCreateAll")

lazy val exercises = (project in file("."))
  .settings(moduleName := "exercises-shapeless")
  .settings(exercisesSettings)
  .enablePlugins(ExerciseCompilerPlugin)

lazy val `project-docs` = (project in file(".docs"))
  .aggregate(exercises)
  .settings(moduleName := "exercises-project-docs")
  .settings(mdocIn := file(".docs"))
  .settings(mdocOut := file("."))
  .settings(skip in publish := true)
  .enablePlugins(MdocPlugin)
