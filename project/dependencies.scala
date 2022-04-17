import sbt._

object dependencies {
  def scalactic(version:String) = "org.scalactic" %% "scalactic" % version
  def scalatest(version:String) = "org.scalatest" %% "scalatest" % version % "test"
  def scalafx(version:String) = "org.scalafx" %% "scalafx" % version
  def codingwell(version:String) = ("net.codingwell" %% "scala-guice" % version).cross(CrossVersion.for3Use2_13)
  def akkaHttpVersion(version:String) = ("com.typesafe.akka" %% "akka-http" % version).cross(CrossVersion.for3Use2_13)
  val googleinject = "com.google.inject" % "guice"% versionNumber.googleinject
  val scalalangmodules = "org.scala-lang.modules" %% "scala-xml" % versionNumber.scalalangmodules
  val typesafeplay = "com.typesafe.play" %% "play-json" % versionNumber.typesafeplay
  val akkaActorTyped = "com.typesafe.akka" %% "akka-actor-typed" % versionNumber.akka
  val akkaStream = "com.typesafe.akka" %% "akka-stream" % versionNumber.akka
  val akkaActor = "com.typesafe.akka" %% "akka-actor" % versionNumber.akka
}

object versionNumber {
  val akka = "2.6.18"
  val scalactic = "3.2.11"
  val scalatest = "3.2.11"
  val scalafx = "17.0.1-R26"
  val googleinject = "5.1.0"
  val codingwell = "5.0.1"
  val scalalangmodules = "2.0.1"
  val typesafeplay = "2.10.0-RC6"
}
