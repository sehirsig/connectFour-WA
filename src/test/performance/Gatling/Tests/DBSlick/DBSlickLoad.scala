
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class DBSlickLoad extends Simulation {

  private val httpProtocol = http
    .baseUrl("http://0.0.0.0:8081")
    .inferHtmlResources(AllowList(), DenyList())
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("de-DE,de;q=0.9,en-US;q=0.8,en;q=0.7")
    .upgradeInsecureRequestsHeader("1")
    .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/101.0.4951.67 Safari/537.36")
  
  private val headers_0 = Map(
  		"Cache-Control" -> "max-age=0",
  		"Proxy-Connection" -> "keep-alive"
  )
  
  private val headers_1 = Map("Proxy-Connection" -> "keep-alive")


  private val scn = scenario("DBSlick Load Test")
    .repeat(100, "i") {
      exec(
        http("Add Player 1")
          .get("/db/addplayer/1/Player1")
          .headers(headers_0)
      )
        .exec(
          http("Add Player 2")
            .get("/db/addplayer/1/Player2")
            .headers(headers_1)
        )
        .pause(1)
        .exec(
          http("Delete all Players")
            .get("/db/deleteallplayers")
            .headers(headers_1)
        )
    }
	setUp(scn.inject(atOnceUsers(10))).protocols(httpProtocol)
}
