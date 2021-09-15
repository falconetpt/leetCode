package exercises.string;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseOnlyLettersTest {
  private ReverseOnlyLetters reverseOnlyLetters;

  @Before
  public void setUp() throws Exception {
    reverseOnlyLetters = new ReverseOnlyLetters();
  }

  @Test
  public void reverseOnlyLetters() {
    assertEquals("dc-ba", reverseOnlyLetters.reverseOnlyLetters("ab-cd"));
  }

  @Test
  public void reverseOnlyLettersw() {
    assertEquals("j-Ih-gfE-dCba", reverseOnlyLetters.reverseOnlyLetters("a-bC-dEf-ghIj"));
  }
}