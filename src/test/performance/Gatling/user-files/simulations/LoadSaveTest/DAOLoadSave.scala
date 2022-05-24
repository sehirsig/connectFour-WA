
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class DAOLoadSave extends Simulation {

  private val httpProtocol = http
    .baseUrl("http://0.0.0.0:8081")
    .inferHtmlResources(AllowList(), DenyList())
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("de,de-DE;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6")
    .upgradeInsecureRequestsHeader("1")
    .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/101.0.4951.64 Safari/537.36 Edg/101.0.1210.47")

  private val headers_0 = Map(
    "Cache-Control" -> "no-cache",
    "Content-Type" -> "application/json",
    "Proxy-Connection" -> "keep-alive"
  )

  private val endurance_test = scenario("Endurance Test")
    .exec(
      http("save grid")
        .post("/db/saveDAO")
        .headers(headers_0)
        .body(RawFileBody("game.json"))
    )
    .pause(2)
    .exec(
      http("load grid")
        .get("/db/loadDAO")
        .headers(headers_0)
    )

  private val spike_test = scenario("Spike Test")
    .exec(
      http("save grid")
        .post("/db/saveDAO")
        .headers(headers_0)
        .body(RawFileBody("game.json"))
    )
    .pause(2)
    .exec(
      http("load grid")
        .get("/db/loadDAO")
        .headers(headers_0)
    )

  private val load_test = scenario("Load Test")
    .exec(
      http("save grid")
        .post("/db/saveDAO")
        .headers(headers_0)
        .body(RawFileBody("game.json"))
    )
    .pause(2)
    .exec(
      http("load grid")
        .get("/db/loadDAO")
        .headers(headers_0)
    )

  private val stress_test = scenario("Stress Test")
    .exec(
      http("save grid")
        .post("/db/saveDAO")
        .headers(headers_0)
        .body(RawFileBody("game.json"))
    )
    .pause(2)
    .exec(
      http("load grid")
        .get("/db/loadDAO")
        .headers(headers_0)
    )

  setUp(
    endurance_test.inject(constantUsersPerSec(30).during(5.minutes))
      .andThen(
        spike_test.inject(nothingFor(5.seconds), atOnceUsers(1000))
          .andThen(
            load_test.inject(atOnceUsers(20))
              .andThen(
                stress_test.inject(rampUsersPerSec(1).to(120).during(2.minutes))))))
                .protocols(httpProtocol)
}
