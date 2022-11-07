package generate

import scala.io.Source

object DadJokeGenerator {

  private val filePath = "src/main/resources/dadjokes.txt"

  def generateDadJoke: DadJoke = {
    val bufferedSource = Source.fromFile(filePath, "UTF-8")
    val jokes = bufferedSource.getLines.toList
    val randomIndex = scala.util.Random.nextInt(jokes.length)
    bufferedSource.close

    DadJoke(jokes(randomIndex))
  }

}
