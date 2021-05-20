package exercises.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class MinMovesTest {
  private MinMoves minMoves;

  @BeforeEach
  private void setup() {
    minMoves = new MinMoves();
  }

  @Test
  public void test1() {
    assertEquals(2, minMoves.minMoves2(new int[] { 1, 2, 3 }));
  }

  @Test
  public void test2() {
    assertEquals(16, minMoves.minMoves2(new int[] { 1,10,2,9 }));
  }

  @Test
  public void test3() {
    assertEquals(14, minMoves.minMoves2(new int[] {1,0,0,8,6 }));
  }
}