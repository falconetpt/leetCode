package exercises.string;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorWithMultTest {
  private CalculatorWithMult calculatorWithMult;

  @Before
  public void setUp() throws Exception {
    calculatorWithMult = new CalculatorWithMult();
  }

  @Test
  public void calculate() {
    assertEquals(10, calculatorWithMult.calculate("2*3+4"));
    assertEquals(42, calculatorWithMult.calculate("42"));
    assertEquals(1, calculatorWithMult.calculate(" 3/2 "));
    assertEquals(7, calculatorWithMult.calculate("3+2*2"));
    assertEquals(5, calculatorWithMult.calculate(" 3+5 / 2 "));

  }
}