package exercises.array;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxResultTest {
  private MaxResult maxResult;

  @Before
  public void setup() {
    maxResult = new MaxResult();
  }

  @Test
  public void test1() {
    assertEquals(7, maxResult.maxResult(new int[]{1,-1,-2,4,-7,3}, 2));
  }

  @Test
  public void test2() {
    assertEquals(17, maxResult.maxResult(new int[]{10,-5,-2,4,0,3}, 3));
  }

  @Test
  public void test3() {
    assertEquals(0, maxResult.maxResult(new int[]{1,-5,-20,4,-1,3,-6,-3}, 2));
  }
}