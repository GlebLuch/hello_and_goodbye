package inheritance

trait MessagesProvider {
  def hello: String
  def goodbye: String
}

final class EnglishMessagesProvider extends MessagesProvider {
  override def hello: String = "Hello"
  override def goodbye: String = "Goodbye"
}

final class RussianMessagesProvider extends MessagesProvider {
  override def hello: String = "Привет"
  override def goodbye: String = "До свидания"
}

final class SpanishMessagesProvider extends MessagesProvider {
  override def hello: String = "Hola"
  override def goodbye: String = "Adios"
}

object Messages {
  import language._

  private val languages = Map(
    EnglishLanguage -> new EnglishMessagesProvider,
    RussianLanguage -> new RussianMessagesProvider,
    SpanishLanguage -> new SpanishMessagesProvider
  )

  def hello(language: Language): String = languages(language).hello
  def goodbye(language: Language): String = languages(language).goodbye
}

object InheritanceMessageApp extends App {
  import Messages._
  import language._

  println(hello(RussianLanguage))
  println(hello(EnglishLanguage))
  println(hello(SpanishLanguage))

  println(goodbye(RussianLanguage))
  println(goodbye(EnglishLanguage))
  println(goodbye(SpanishLanguage))
}
