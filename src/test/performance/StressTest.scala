package de.htwg.se.ConnectFour

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class StressTest extends Simulation {

  val httpProtocol = http
    // Here is the root for all relative URLs
    .baseUrl("http://localhost:8081")
    // Here are the common headers
    .acceptHeader(
      "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8"
    )
    .doNotTrackHeader("1")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader(
      "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0"
    )

  // A scenario is a chain of requests and pauses
  val stress = scenario("Testing Database - Stress")
    .exec(
      http("create database")
        .get("/createDAO")
    )
    .pause(1)
    .exec(
      http("delete database")
        .get("/deleteDAO")
    )
  setUp(
    stress.inject(rampUsersPerSec(2).to(1200).during(2.minutes))
  ).protocols(httpProtocol)

}