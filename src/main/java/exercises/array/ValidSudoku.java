package exercises.array;

import java.util.HashSet;

public class ValidSudoku {
  public boolean isValidSudoku(final char[][] board) {
    return validLines(board)
      && validCol(board)
      && validSquare(board, 0, 0);
  }

  private boolean validSquare(final char[][] board, final int startRow, final int startCol) {
    if (startRow >= board.length || startCol >= board.length) return true;

    final var seen = new HashSet<Character>();
    for (int i = startRow; i < startRow + 3; i++) {

      for (int j = startCol; j < startCol + 3; j++) {
        final var element = board[i][j];

        if (seen.contains(element)) return false;
        if (element != '.') seen.add(element);
      }
    }

    return validSquare(board, startRow + 3, startCol)
      && validSquare(board, startRow, startCol + 3);
  }

  private boolean validLines(final char[][] board) {
    for (int i = 0; i < board.length; i++) {
      final var seen = new HashSet<Character>();
      for (int j = 0; j < board[i].length; j++) {
        final var element = board[i][j];

        if (seen.contains(element)) return false;
        if (element != '.') seen.add(element);
      }
    }

    return true;
  }

  private boolean validCol(final char[][] board) {
    for (int i = 0; i < board.length; i++) {
      final var seen = new HashSet<Character>();
      for (int j = 0; j < board[i].length; j++) {
        final var element = board[j][i];

        if (seen.contains(element)) return false;
        if (element != '.') seen.add(element);
      }
    }

    return true;
  }
}
