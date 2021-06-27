package exercises.array;

import io.cucumber.java8.Ca;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CandyTest {
  private Candy candy;

  @Before
  public void setUp() {
    candy = new Candy();
  }

  @Test
  public void test1() {
    assertEquals(5, candy.candy(new int[] {1, 0, 2}));
  }
}