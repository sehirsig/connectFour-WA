/** Database */

name := "ConnectFour-Database"
organization  := "de.htwg.se"
version := "0.5.0-SNAPSHOT"
crossScalaVersions ++= Seq("2.13.6", "3.1.1")
libraryDependencies += "org.slf4j" % "slf4j-nop" % "2.0.0-alpha7"
libraryDependencies += "com.typesafe.slick" %% "slick" % "3.4.0-M1"