package generate

import zio.{Task, ULayer, ZIO, ZLayer}

import scala.io.Source
import scala.util.Try

trait DadJokeGenerator {
  def getRandomDadJokeZIO: Task[DadJoke]
}

object DadJokeGenerator {

  final case class LiveDadJokeGenerator(filePath: String) extends DadJokeGenerator {
    def getRandomDadJokeZIO: Task[DadJoke] = for {
      bufferedSource <- ZIO.fromTry(Try(Source.fromFile(filePath, "UTF-8"))).mapError(CantOpenDadJokeFile(filePath, _))
      jokes = bufferedSource.getLines.toList
      randomIndex = scala.util.Random.nextInt(jokes.length)
      _ <- ZIO.fromTry(Try(bufferedSource.close)).mapError(CantCloseDadJokeFile(filePath, _))
    } yield DadJoke(jokes(randomIndex))

  }

  private val filePath = "src/main/resources/dadjokes.txt"

  val liveLayer: ULayer[LiveDadJokeGenerator] =
    ZLayer.succeed(LiveDadJokeGenerator(filePath))

}
