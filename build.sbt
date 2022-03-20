val scala3Version = "3.1.1"

lazy val root = project
  .in(file("."))
  .settings(
    name := "ConnectFour",
    version := "0.5.0-SNAPSHOT",
    scalaVersion := scala3Version,
    crossScalaVersions ++= Seq("2.13.5", "3.1.1"),
    libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.10",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.10" % "test",
    libraryDependencies += ("org.scalafx" %% "scalafx" % "16.0.0-R24"),
    libraryDependencies += ("com.google.inject" % "guice"% "5.0.1"),
    libraryDependencies += ("net.codingwell" %% "scala-guice" % "5.0.1").cross(CrossVersion.for3Use2_13),
    libraryDependencies += "org.scala-lang.modules" %% "scala-xml" % "2.0.1",
    libraryDependencies += ("com.typesafe.play" %% "play-json" % "2.9.2").cross(CrossVersion.for3Use2_13),
    jacocoCoverallsServiceName := "github-actions",
    jacocoCoverallsBranch := sys.env.get("CI_BRANCH"),
    jacocoCoverallsPullRequest := sys.env.get("GITHUB_EVENT_NAME"),
    jacocoCoverallsRepoToken := sys.env.get("COVERALLS_REPO_TOKEN"),
    jacocoExcludes in Test := Seq(
      "de.htwg.se.ConnectFour.aUI*",
        "de.htwg.se.ConnectFour.model.fileio*",
        "de.htwg.se.ConnectFour.Game;"
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
        .map(m => "org.openjfx" % s"javafx-$m" % "16" classifier osName)
    }
  )
  .enablePlugins(JacocoCoverallsPlugin)