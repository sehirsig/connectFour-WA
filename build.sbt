import sbt.Keys.libraryDependencies

val scala3Version = "3.1.1"

lazy val commonSettings = Seq(
  scalaVersion := scala3Version,
  organization := "de.htwg.se",

  libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.11",
  libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.11" % "test",

  libraryDependencies += ("org.scalafx" %% "scalafx" % "17.0.1-R26"),

  libraryDependencies += ("com.google.inject" % "guice"% "5.1.0"),
  libraryDependencies += ("net.codingwell" %% "scala-guice" % "5.0.1").cross(CrossVersion.for3Use2_13),

  libraryDependencies += "org.scala-lang.modules" %% "scala-xml" % "2.0.1",
  libraryDependencies += ("com.typesafe.play" %% "play-json" % "2.10.0-RC6"),

  jacocoCoverallsServiceName := "github-actions",
  jacocoCoverallsBranch := sys.env.get("CI_BRANCH"),
  jacocoCoverallsPullRequest := sys.env.get("GITHUB_EVENT_NAME"),
  jacocoCoverallsRepoToken := sys.env.get("COVERALLS_REPO_TOKEN"),
  jacocoExcludes in Test := Seq(
    "de.htwg.se.ConnectFour.aUI*",
    "fileIOComponent*",
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

lazy val model = (project in file("Model"))
  .settings(
    name := "ConnectFour-Model",
    version := "0.5.0-SNAPSHOT",
    commonSettings,
  )

lazy val persistence = (project in file("Persistence"))
  .dependsOn(model)
  .settings(
    name := "ConnectFour-Persistence",
    version := "0.5.0-SNAPSHOT",
    commonSettings,
  )

lazy val tools = (project in file("Tools"))
  .settings(
    name := "ConnectFour-Tools",
    version := "0.5.0-SNAPSHOT",
    commonSettings,
  )

lazy val root = project
  .in(file("."))
  .dependsOn(tools, model, persistence)
  .aggregate(tools, model, persistence)
  .settings(
    name := "ConnectFour",
    version := "0.5.0-SNAPSHOT",
    commonSettings,
  )
  .enablePlugins(JacocoCoverallsPlugin)
