
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class SpikeTestSmall extends Simulation {

  private val httpProtocol = http
    .baseUrl("http://0.0.0.0:8081")
    .inferHtmlResources(AllowList(), DenyList())
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("de,de-DE;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6")
    .upgradeInsecureRequestsHeader("1")
    .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/101.0.4951.64 Safari/537.36 Edg/101.0.1210.47")
  
  private val headers_0 = Map(
  		"Cache-Control" -> "max-age=0",
  		"Proxy-Connection" -> "keep-alive"
  )


  private val scn = scenario("Testing Database - Spike")
    .exec(
      http("create database")
        .get("/db/createDAO")
    )
    .exec(
      http("delete database")
        .get("/db/deleteDAO")
    )

	setUp(scn.inject(atOnceUsers(3000))).protocols(httpProtocol)
}
