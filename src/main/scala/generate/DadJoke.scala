package generate

import zio.Console.printLine
import zio.UIO

final case class DadJoke(joke: String) {
  def print: UIO[Unit] = printLine(joke).orDie
}