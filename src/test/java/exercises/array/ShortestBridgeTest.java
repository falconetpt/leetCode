package exercises.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class ShortestBridgeTest {
  private ShortestBridge shortestBridge;

  @BeforeEach
  private void setup() {
    shortestBridge = new ShortestBridge();
  }

  @Test
  void test1() {
    final var land = new int[][] {
      new int[] {1, 0},
      new int[] {0, 1}
    };

    assertEquals(1, shortestBridge.shortestBridge(land));
  }

  @Test
  void test2() {
    final var land = new int[][] {
      new int[] {0,1,0},
      new int[] {0,0,0},
      new int[] {0,0,1}
    };

    assertEquals(2, shortestBridge.shortestBridge(land));
  }
}