import sbt._

object dependencies {
  val scalactic = "org.scalactic" %% "scalactic" % versionNumber.scalactic
  val scalatest = "org.scalatest" %% "scalatest" % versionNumber.scalatest % "test"
  val scalamock = ("org.scalamock" %% "scalamock" % versionNumber.scalamock % Test).cross(CrossVersion.for3Use2_13)

  val scalafx = "org.scalafx" %% "scalafx" % versionNumber.scalafx

  val codingwell = ("net.codingwell" %% "scala-guice" % versionNumber.codingwell).cross(CrossVersion.for3Use2_13)

  val googleinject = "com.google.inject" % "guice" % versionNumber.googleinject

  val scalalangmodules = "org.scala-lang.modules" %% "scala-xml" % versionNumber.scalalangmodules

  val typesafeplay = "com.typesafe.play" %% "play-json" % versionNumber.typesafeplay


  val akkaHttp = ("com.typesafe.akka" %% "akka-http" % versionNumber.akkaHttpVersion).cross(CrossVersion.for3Use2_13)
  val akkaHttpSpray = ("com.typesafe.akka" %% "akka-http-spray-json" % versionNumber.akkaHttpVersion).cross(CrossVersion.for3Use2_13)
  val akkaHttpCore = ("com.typesafe.akka" %% "akka-http-core" % versionNumber.akkaHttpVersion).cross(CrossVersion.for3Use2_13)
  val akkaActorTyped = ("com.typesafe.akka" %% "akka-actor-typed" % versionNumber.akka).cross(CrossVersion.for3Use2_13)
  val akkaStream = ("com.typesafe.akka" %% "akka-stream" % versionNumber.akka).cross(CrossVersion.for3Use2_13)
  val akkaActor = ("com.typesafe.akka" %% "akka-actor" % versionNumber.akka).cross(CrossVersion.for3Use2_13)

  val slf4jNop = "org.slf4j" % "slf4j-nop" % versionNumber.slf4jNop
  val slick = ("com.typesafe.slick" %% "slick" % versionNumber.slick).cross(CrossVersion.for3Use2_13)
  val hikarislick = ("com.typesafe.slick" %% "slick-hikaricp" % versionNumber.hikarislick).cross(CrossVersion.for3Use2_13)
  val postgresql = "org.postgresql" % "postgresql" % versionNumber.postgresql
  val mongoDb = ("org.mongodb.scala" %% "mongo-scala-driver" % versionNumber.mongoDb).cross(CrossVersion.for3Use2_13)
}

object versionNumber {
  val akka = "2.6.19"
  val akkaHttpVersion = "10.2.9"
  val scalactic = "3.2.11"
  val scalatest = "3.2.11"
  val scalamock = "5.1.0"
  val scalafx = "17.0.1-R26"
  val googleinject = "5.1.0"
  val codingwell = "5.0.1"
  val scalalangmodules = "2.0.1"
  val typesafeplay = "2.10.0-RC6"
  val slf4jNop = "2.0.0-alpha7"
  val slick = "3.4.0-M1"
  val hikarislick = "3.3.3"
  val postgresql = "42.3.4"
  val mongoDb = "4.6.0"
}
