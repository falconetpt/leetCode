package exercises.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReversePolishNotationTest {
  private ReversePolishNotation reversePolishNotation = new ReversePolishNotation();
  @Test
  public void test1() {
    final var actual = reversePolishNotation
      .evalRPN(new String[]{"2","1","+","3","*"});

    assertEquals(9, actual);
  }

  @Test
  public void test2() {
    final var actual = reversePolishNotation
      .evalRPN(new String[]{"4","13","5","/","+"});

    assertEquals(6, actual);
  }

  @Test
  public void test3() {
    final var actual = reversePolishNotation
      .evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"});

    assertEquals(22, actual);
  }
}