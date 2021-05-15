package exercises.string;

import org.junit.Test;

import java.util.stream.Stream;

import static org.junit.Assert.*;

public class IsNumberTest {
  private IsNumber isNumber = new IsNumber();

  @Test
  public void validIntegerReturnTrue() {
    assertTrue(isNumber.isNumber("1"));
  }

  @Test
  public void validNegativeIntegerReturnTrue() {
    assertTrue(isNumber.isNumber("-45"));
  }

  @Test
  public void validPositiveIntegerReturnTrue() {
    assertTrue(isNumber.isNumber("+78"));
  }

  @Test
  public void validDecimalReturnTrue() {
    assertTrue(isNumber.isNumber("490.36"));
  }

  @Test
  public void validPositiveDecimalReturnTrue() {
    assertTrue(isNumber.isNumber("+0.0013"));
  }

  @Test
  public void validNegativeDecimalReturnTrue() {
    assertTrue(isNumber.isNumber("-.12"));
  }

  @Test
  public void alphabetLetterReturnFalse() {
    assertFalse(isNumber.isNumber("1a"));
  }

  @Test
  public void exponentialNegativeReturnTrue() {
    assertTrue(Stream.of("2", "0089", "-0.1", "+3.14",
      "4.", "-.9", "2e10", "-90E3", "3e+7",
      "+6e-1", "53.5e93", "-123.456e789")
      .allMatch(isNumber::isNumber));
  }
}