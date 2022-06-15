
name := "ConnectFour-Util"
organization  := "de.htwg.se.ConnectFour"
version       := "0.5.0-SNAPSHOT"
scalaVersion := "3.1.1"

lazy val commonDependencies = Seq(
  dependencies.scalactic,
  dependencies.scalatest,
  dependencies.scalafx,
  dependencies.codingwell,
  dependencies.googleinject,
  dependencies.scalalangmodules,
  dependencies.typesafeplay
)

libraryDependencies ++= commonDependencies