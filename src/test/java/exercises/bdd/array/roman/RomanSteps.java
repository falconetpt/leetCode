package exercises.bdd.array.roman;

import exercises.string.DecodeString;
import exercises.string.RomanNumeral;
import io.cucumber.java8.En;

import static org.junit.Assert.assertEquals;

public class RomanSteps implements En {
  private String value;
  private int result;

  public RomanSteps() {
    Given("a input {string}", (String string) -> {
      value = string;
    });
    When("i invoque conversion", () -> {
      result = RomanNumeral.convert(value);
    });
    Then("the result should be value {int}", (Integer expected) -> {
      assertEquals(expected.intValue(), result);
    });
  }
}