package inheritance

import org.scalatest.flatspec._
import org.scalatest.matchers._

class EnglishMessagesProviderSpec extends AnyFlatSpec with should.Matchers {

  private val messages = new EnglishMessagesProvider

  "EnglishMessagesProvider" should "provide hello message" in {
    messages.hello should be ("Hello")
  }

  it should "provide goodbye message" in {
    messages.goodbye should be ("Goodbye")
  }

}
