package exercises.array;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class MaxAreaSquareTest {

  @Test
  void test() {
    new MaxArea().maxArea(5 , 4,
        new int[] {3,1}, new int[] {1});
  }
}