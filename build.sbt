import sbt.Keys.libraryDependencies

/** ScalaVersion */
val scala3Version = "3.1.1"

/** Dependencies */
lazy val commonDependencies = Seq(
  dependencies.scalactic,
  dependencies.scalatest,
  dependencies.scalafx,
  dependencies.codingwell,
  dependencies.akkaHttp,
  dependencies.akkaHttpSpray,
  dependencies.akkaHttpCore,
  dependencies.slf4jNop,
  dependencies.googleinject,
  dependencies.scalalangmodules,
  dependencies.typesafeplay,
  dependencies.akkaActor,
  dependencies.akkaStream,
  dependencies.akkaActorTyped,
  dependencies.slick,
  dependencies.slf4jNop
)

/** Database */
lazy val database = (project in file("Database"))
  .settings(
    name := "ConnectFour-Database",
    organization  := "de.htwg.se",
    version := "0.5.0-SNAPSHOT",
    crossScalaVersions ++= Seq("2.13.6", "3.1.1"),
    libraryDependencies += "org.slf4j" % "slf4j-nop" % "2.0.0-alpha7",
    libraryDependencies += "com.typesafe.slick" %% "slick" % "3.4.0-M1",
    libraryDependencies += "org.postgresql" % "postgresql" % "42.3.4",
    commonSettings,
  )

/** Persistence Module */
lazy val persistence = (project in file("Persistence"))
  .settings(
    name := "ConnectFour-Persistence",
    version := "0.5.0-SNAPSHOT",
    commonSettings,
    libraryDependencies ++= commonDependencies,
  )

/** Root Module */
lazy val root = project
  .in(file("."))
  .dependsOn(database)
  .settings(
    name := "ConnectFour",
    version := "0.5.0-SNAPSHOT",
    commonSettings,
    libraryDependencies ++= commonDependencies,
  )
  .enablePlugins(JacocoCoverallsPlugin)

/** Common Settings */
lazy val commonSettings = Seq(
  scalaVersion := scala3Version,
  organization := "de.htwg.se",

  jacocoCoverallsServiceName := "github-actions",
  jacocoCoverallsBranch := sys.env.get("CI_BRANCH"),
  jacocoCoverallsPullRequest := sys.env.get("GITHUB_EVENT_NAME"),
  jacocoCoverallsRepoToken := sys.env.get("COVERALLS_REPO_TOKEN"),
  jacocoExcludes in Test := Seq(
    "de.htwg.se.ConnectFour.aUI*",
    "de.htwg.se.ConnectFour.fileIOComponent*",
    "de.htwg.se.ConnectFour.ConnectFour*"
  ),
  libraryDependencies ++= {
    // Determine OS version of JavaFX binaries
    lazy val osName = System.getProperty("os.name") match {
      case n if n.startsWith("Linux") => "linux"
      case n if n.startsWith("Mac") => "mac"
      case n if n.startsWith("Windows") => "win"
      case _ => throw new Exception("Unknown platform!")
    }

    Seq("base", "controls", "fxml", "graphics", "media", "swing", "web")
      .map(m => "org.openjfx" % s"javafx-$m" % "17.0.1" classifier osName)
  }
)
