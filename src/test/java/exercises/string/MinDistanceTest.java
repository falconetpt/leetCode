package exercises.string;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinDistanceTest {
  private final MinDistance minDistance = new MinDistance();

  @Test
  public void test1() {
    assertEquals(0, minDistance.minDistance("", ""));
  }

  @Test
  public void test5() {
    assertEquals(3, minDistance.minDistance("eat", ""));
  }


  @Test
  public void test6() {
    assertEquals(4, minDistance.minDistance("leetcode", "etco"));
  }

  @Test
  public void test7() {
    assertEquals(3, minDistance.minDistance("park", "spake"));
  }


  @Test
  public void test2() {
    assertEquals(2, minDistance.minDistance("eat", "sea"));
  }

  @Test
  public void test3() {
    assertEquals(0, minDistance.minDistance("eat", "eat"));
  }

  @Test
  public void test4() {
    assertEquals(2, minDistance.minDistance("eat", "sea"));
  }

}