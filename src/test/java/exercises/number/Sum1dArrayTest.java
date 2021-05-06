package exercises.number;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Sum1dArrayTest {
  private final Sum1dArray sumArray = new Sum1dArray();

  @Test
  public void nullList_shouldReturnNullList() {
    assertArrayEquals(new int[] {}, sumArray.runningSum(new int[] {}));
  }

  @Test
  public void emptyList_shouldReturnEmptyList() {
    assertArrayEquals(new int[] {}, sumArray.runningSum(new int[] {}));
  }

  @Test
  public void oneElementList_shouldReturnSameElementList() {
    assertArrayEquals(new int[] {1}, sumArray.runningSum(new int[] {1}));
  }

  @Test
  public void twoElementList_shouldReturnTwoElementListWithIncrementalSum() {
    assertArrayEquals(new int[] {1, 4}, sumArray.runningSum(new int[] {1, 3}));
  }

}