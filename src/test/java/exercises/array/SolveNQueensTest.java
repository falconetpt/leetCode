package exercises.array;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolveNQueensTest {
  private SolveNQueens solveNQueens = new SolveNQueens();

  @Test
  void test1() {
    final var expected = List.of(
      List.of(
        List.of(
          ".Q..",
          "...Q",
          "Q...",
          "..Q."
        ),
        List.of(
          "..Q.",
          "Q...",
          "...Q",
          ".Q.."
        )
      )
    );
    assertEquals( expected, solveNQueens.solveNQueens( 4 ) );
  }

}