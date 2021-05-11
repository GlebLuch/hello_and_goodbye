package inheritance

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should
import org.scalatest.prop.TableDrivenPropertyChecks

class MessageSpec extends AnyFlatSpec with should.Matchers with TableDrivenPropertyChecks {

  import language._

  private val languages = Table(
    ("Language", "Hello Message"),
    (EnglishLanguage, "Hello"),
    (RussianLanguage, "Привет"),
    (SpanishLanguage, "Hola")
  )

  import Messages._

  "hello" should "return hello message in appropriate language" in {
    forAll (languages) { (language, helloMessage) =>
      hello(language) should be (helloMessage)
    }
  }

  "goodbye"should "return goodbye message in appropriate language" in {
    ???
  }
}
