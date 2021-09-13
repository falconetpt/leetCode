package exercises.string;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BasicCalculatorTest {

  private BasicCalculator basicCalculator;

  @Before
  public void setUp() throws Exception {
    basicCalculator = new BasicCalculator();
  }

  @Test
  public void calculate_onePlusOne() {
    assertEquals(2, basicCalculator.calculate("1 + 1"));
  }

  @Test
  public void calculate_minusFifteenPlusOne() {
    assertEquals(-14, basicCalculator.calculate("-15 + 1"));
  }

  @Test
  public void calculate_multiple() {
    assertEquals(4, basicCalculator.calculate("-15 + 1-12+30"));
  }

  @Test
  public void calculate_withParenthesis() {
    assertEquals(-31, basicCalculator.calculate("15 - (30 + 16)"));
  }

  @Test
  public void calculate_withParenthesis2() {
    assertEquals(23, basicCalculator.calculate("(1+(4+5+2)-3)+(6+8)"));
  }

  @Test
  public void calculate_simple() {
    assertEquals(2, basicCalculator.calculate("1+5-4"));
  }
}