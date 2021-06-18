package exercises.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumArrayTest {
  @Test
  public void test1() {
    final var numsArr = new NumArray(new int[] { 1, 3, 5 });

    assertEquals(9, numsArr.sumRange(0, 2));
    numsArr.update(1, 2);
    assertEquals(8, numsArr.sumRange(0, 2));
  }

  @Test
  public void test2() {
    final var numsArr = new NumArray(new int[] { 9, -8 });

    numsArr.update(0, 3);
    assertEquals(-8, numsArr.sumRange(1, 1));
    assertEquals(-5, numsArr.sumRange(0, 1));
    numsArr.update(1, -3);
    assertEquals(0, numsArr.sumRange(0, 1));
  }
}