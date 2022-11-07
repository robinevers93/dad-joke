import zio.durationInt
import zio.test.{TestClock, TestConsole, ZIOSpecDefault, assertTrue}

object DadJokeAppTest extends ZIOSpecDefault {

  def spec = suite("DadJokeApp") {
    test("test") {
      for {
        _ <- DadJokeApp.appLogic.fork
        _ <- TestClock.adjust(2.seconds)
        result <- TestConsole.output
      } yield assertTrue(result == Vector("Today's dad joke is:\n\n", "This is a test joke\n"))

    }

  }

}
