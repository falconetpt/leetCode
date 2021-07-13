package exercises.array;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayPairSumTest {
  private ArrayPairSum arrayPairSum;

  @Before
  public void setUp() {
    arrayPairSum = new ArrayPairSum();
  }

  @Test
  public void arrayPairSum() {
    final var result = arrayPairSum
      .arrayPairSum(new int[] {6,2,6,5,1,2});

    assertEquals(9, result);
  }
}