
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class SpikeUITest extends Simulation {

  private val httpProtocol = http
    .baseUrl("http://0.0.0.0:8080")
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


  private val scn = scenario("SpikeUITest")
    .exec(
        http("Create new Game")
          .get("/newgame")
          .headers(headers_0)
      )
        .exec(
          http("Drop at 2")
            .get("/drop/2")
            .headers(headers_0)
        )
        .exec(
          http("Undo move")
            .get("/undo")
            .headers(headers_0)
        )
        .exec(
          http("Redo Move")
            .get("/redo")
            .headers(headers_0)
        )
        .pause(1)

	setUp(scn.inject(atOnceUsers(30000))).protocols(httpProtocol)
}
