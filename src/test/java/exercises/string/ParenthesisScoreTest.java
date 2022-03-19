package exercises.string;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParenthesisScoreTest {
  private ParenthesisScore parenthesisScore;

  @Before
  public void setUp() throws Exception {
    parenthesisScore = new ParenthesisScore();
  }

  @Test
  public void scoreOfParentheses_emptyString_returns0() {
    assertEquals(0, parenthesisScore.scoreOfParentheses(""));
  }

  @Test
  public void scoreOfParentheses_simpleParetheses_returns1() {
    assertEquals(1, parenthesisScore.scoreOfParentheses("()"));
  }

  @Test
  public void scoreOfParentheses_doubleParentheses_returns2() {
    assertEquals(2, parenthesisScore.scoreOfParentheses("()()"));
  }

  @Test
  public void scoreOfParentheses_doubleInsideParentheses_returns2() {
    assertEquals(2, parenthesisScore.scoreOfParentheses("(())"));
  }

  @Test
  public void scoreOfParentheses_doubleInsideTwoParentheses_returns4() {
    assertEquals(4, parenthesisScore.scoreOfParentheses("(()())"));
  }
}