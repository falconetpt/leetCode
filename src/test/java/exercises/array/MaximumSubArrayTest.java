package exercises.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumSubArrayTest {
  private MaximumSubArray maximumSubArray;

  @BeforeEach
  private void setup() {
    maximumSubArray = new MaximumSubArray();
  }

  @Test
  void test1() {
    assertEquals( 4, maximumSubArray.maximumSum( new int[] {1,-2,0,3} ) );
  }

}