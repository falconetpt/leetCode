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
}