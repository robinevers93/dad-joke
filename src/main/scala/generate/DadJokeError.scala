package generate

sealed trait DadJokeError extends Throwable

final case class CantOpenDadJokeFile(filePath: String, e: Throwable) extends DadJokeError {
  override def getMessage: String = s"Dad Joke file can't be opened [path: $filePath, error: ${e.getMessage}]."
}

final case class CantCloseDadJokeFile(filePath: String, e: Throwable) extends DadJokeError {
  override def getMessage: String = s"Dad Joke file can't be closed [path: $filePath, error: ${e.getMessage}]."
}
