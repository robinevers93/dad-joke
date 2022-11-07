ThisBuild / scalaVersion     := "2.13.10"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.imanage"
ThisBuild / organizationName := "imanage"

lazy val root = (project in file("."))
  .settings(
    name := "dad-joke",
    libraryDependencies ++= Seq(
      "dev.zio" %% "zio" % "2.0.3",
      "dev.zio" %% "zio-test" % "2.0.3" % Test
    ),
    testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework")
  )
