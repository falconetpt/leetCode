package exercises.array;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixReshapeTest {
  private MatrixReshape matrixReshape;

  @Before
  public void setUp() throws Exception {
    matrixReshape = new MatrixReshape();
  }

  @Test
  public void matrixReshape_withLinearArray_returns() {
    assertArrayEquals(
      new int[][] {{1, 2, 3, 4}},
      matrixReshape.matrixReshape(new int[][]{{1, 2}, {3, 4}}, 1, 4)
    );
  }

  @Test
  public void matrixReshape_withDoubleArray_returns() {
    assertArrayEquals(
      new int[][] {{1, 2}, {3, 4}},
      matrixReshape.matrixReshape(new int[][]{{1,2},{3,4}}, 2, 4)
    );
  }
}