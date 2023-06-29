package exercises.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumEnclavesTest {

  @Test
  public void numEnclaves() {
    final var arr = new int[][]{
      {0, 0, 0, 1, 1, 1, 0, 1, 0, 0},
      {1, 1, 0, 0, 0, 1, 0, 1, 1, 1},
      {0, 0, 0, 1, 1, 1, 0, 1, 0, 0},
      {0, 1, 1, 0, 0, 0, 1, 0, 1, 0},
      {0, 1, 1, 1, 1, 1, 0, 0, 1, 0},
      {0, 0, 1, 0, 1, 1, 1, 1, 0, 1},
      {0, 1, 1, 0, 0, 0, 1, 1, 1, 1},
      {0, 0, 1, 0, 0, 1, 0, 1, 0, 1},
      {1, 0, 1, 0, 1, 1, 0, 0, 0, 0},
      {0, 0, 0, 0, 1, 1, 0, 0, 0, 1}
    };

    new NumEnclaves().numEnclaves(arr);
  }
}