package generate

import zio.{Task, ULayer, ZIO, ZLayer}

object DadJokeGeneratorTest {

  final case class TestDadJokeGenerator(joke: DadJoke) extends DadJokeGenerator {
    def getRandomDadJokeZIO: Task[DadJoke] = ZIO.succeed(joke)
  }

  val testLayer: ULayer[TestDadJokeGenerator] =
    ZLayer.succeed(TestDadJokeGenerator(DadJoke("This is a test joke")))
}
