package exercises.u.exercises;

import org.junit.Test;

import static org.junit.Assert.*;

public class LeftMostElementTest {
  @Test
  public void test() {
    final var leftMostElement = new LeftMostElement();

    final var result = leftMostElement.leftMostElement(
        new int[][]{
            {0, 0, 0, 1},
            {0, 1, 1, 1},
            {0, 0, 1, 1},
            {0, 0, 0, 0}
        }
    );

    final var result2 = leftMostElement.leftMostElement(
        new int[][]{
            {0, 0},
            {0, 0}
        }
    );

    assertEquals(1, result);
    assertEquals(-1, result2);
  }
}