package type_class

import org.scalatest.flatspec._
import org.scalatest.matchers._

class HelloMessageProviderSpec extends AnyFlatSpec with should.Matchers {

  private val englishHelloMessageProvider = new EnglishHelloMessageProvider
  private val russianHelloMessageProvider = new RussianHelloMessageProvider
  private val spanishHelloMessageProvider = new SpanishHelloMessageProvider

  "EnglishHelloMessageProvider" should "provide hello message" in {
    englishHelloMessageProvider.message should be ("Hello")
  }

  "RussianHelloMessageProvider"should "provide hello message" in{
    russianHelloMessageProvider.message should be ("Привет")
  }
  "SpanishHelloMessageProvider"should "provide hello message" in{
    spanishHelloMessageProvider.message should be ("Hola")
  }
}

class GoodbyeMessageProviderSpec extends AnyFlatSpec with should.Matchers{
  private val englishGoodbyeMessageProvider = new EnglishGoodbyeMessageProvider
  private val russianGoodbyeMessageProvider = new RussianGoodbyeMessageProvider
  private val spanishGoodbyeMessageProvider = new SpanishGoodbyeMessageProvider

  "EnglishGoodbyeMessageProvider" should "provide goodbye message" in {
    englishGoodbyeMessageProvider.message should be ("Goodbye")
  }
  "RussianGoodbyeMessageProvider" should "provide goodbye message" in {
    russianGoodbyeMessageProvider.message should be ("Пока")
  }
  "SpanishGoodbyeMessageProvider" should "provide goodbye message" in {
    spanishGoodbyeMessageProvider.message should be ("Adios")
  }
}