import generate.DadJokeGenerator
import zio.Console.printLine
import zio._

object DadJokeApp extends ZIOAppDefault {

  def appLogic: RIO[DadJokeGenerator, ExitCode] = for {
    _ <- printLine(s"Today's dad joke is:\n").orDie
    _ <- ZIO.sleep(1.second) // wait to build up suspense
    jokeGenerator <- ZIO.service[DadJokeGenerator]
    joke <- jokeGenerator.getRandomDadJokeZIO
    _ <- joke.print
  } yield ExitCode.success

  override def run: Task[ExitCode] =
    appLogic.provide(DadJokeGenerator.liveLayer)
}