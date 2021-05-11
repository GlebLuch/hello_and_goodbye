package type_class

import language._

trait MessageProvider {
  def message: String
}

trait HelloMessageProvider[L <: Language] extends MessageProvider {
  override def message: String
}

final class EnglishHelloMessageProvider extends HelloMessageProvider[EnglishLanguage.type] {
  override def message: String = "Hello"
}

final class RussianHelloMessageProvider extends HelloMessageProvider[RussianLanguage.type] {
  override def message: String = "Привет"
}

final class SpanishHelloMessageProvider extends HelloMessageProvider[SpanishLanguage.type] {
  override def message: String = "Hola"
}

object HelloMessageProvider {

  implicit val englishHelloMessageProvider: HelloMessageProvider[EnglishLanguage.type] =
    new EnglishHelloMessageProvider

  implicit val russianHelloMessageProvider: HelloMessageProvider[RussianLanguage.type] =
    new RussianHelloMessageProvider

  implicit val spanishHelloMessageProvider: HelloMessageProvider[SpanishLanguage.type] =
    new SpanishHelloMessageProvider
}

trait GoodbyeMessageProvider[L <: Language] extends MessageProvider {
  override def message: String
}

final class EnglishGoodbyeMessageProvider extends GoodbyeMessageProvider[EnglishLanguage.type] {
  override def message: String = "Goodbye"
}

final class RussianGoodbyeMessageProvider extends GoodbyeMessageProvider[RussianLanguage.type] {
  override def message: String = "Пока"
}

final class SpanishGoodbyeMessageProvider extends GoodbyeMessageProvider[SpanishLanguage.type] {
  override def message: String = "Adios"
}

object GoodbyeMessageProvider {

   implicit val englishGoodbyeMessageProvider: GoodbyeMessageProvider[EnglishLanguage.type] =
    new EnglishGoodbyeMessageProvider

   implicit val russianGoodbyeMessageProvider: GoodbyeMessageProvider[RussianLanguage.type] =
    new RussianGoodbyeMessageProvider

   implicit val spanishGoodbyeMessageProvider: GoodbyeMessageProvider[SpanishLanguage.type] =
    new SpanishGoodbyeMessageProvider
}

object Messages {
  def hello[L <: Language](language: Language)(implicit helloMessageProvider: HelloMessageProvider[L]): String =
    helloMessageProvider.message

  def goodbye[L <: Language](language: Language)(implicit goodbyeMessageProvider: GoodbyeMessageProvider[L]): String =
    goodbyeMessageProvider.message
}

object TypeClassMessagesApp extends App {

  import Messages._

  println(hello[EnglishLanguage.type](EnglishLanguage))
  println(hello[RussianLanguage.type ](RussianLanguage))
  println(hello[SpanishLanguage.type ](SpanishLanguage))

  println(goodbye[EnglishLanguage.type](EnglishLanguage))
  println(goodbye[RussianLanguage.type ](RussianLanguage))
  println(goodbye[SpanishLanguage.type ](SpanishLanguage))
}
