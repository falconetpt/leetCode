package exercises.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConstructArrayTest {
  final ConstructArray constructArray = new ConstructArray();

  @Test
  public void constructArray_1() {
    assertEquals( true, constructArray.isPossible( new int[] { 1 } ) );
  }

  @Test
  public void constructArray_2() {
    assertEquals( false, constructArray.isPossible( new int[] { 2 } ) );
  }

  @Test
  public void constructArray_3() {
    assertEquals( true, constructArray.isPossible( new int[] { 1, 2 } ) );
  }

}