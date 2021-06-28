package exercises.array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class SolveNQueens {
  public List<List<String>> solveNQueens(final int n) {
    final var x = new String[n][n];

    IntStream.range( 0, n )
      .peek( i -> Arrays.fill(x[i], ".") )
      .forEach( i -> x[i][i] = "Q" );

    return List.of();
  }
}
