package exercises.array;

import java.util.Arrays;

public class SorroundedRegion {
  public void solve(final char[][] board) {
    final var line = new int[board.length][2];
    for (int i = 0; i < line.length; i++) {
      line[i][0] = Integer.MAX_VALUE;
      line[i][1] = Integer.MIN_VALUE;
    }

    final var col = new int[board[0].length][2];
    for (int i = 0; i < col.length; i++) {
      col[i][0] = Integer.MAX_VALUE;
      col[i][1] = Integer.MIN_VALUE;
    }

    for (int i = 0; i < board.length; i++) {

      final var lineArr = line[i];
      for (int j = 0; j < board[i].length; j++) {
        final var element = board[i][j];

        if (element == 'X') {
          final var colArr = col[j];

          lineArr[0] = Math.min(lineArr[0], j);
          lineArr[1] = Math.max(lineArr[1], j);
          colArr[0] = Math.min(colArr[0], i);
          colArr[1] = Math.max(colArr[1], i);
        }
      }
    }

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        final var element = board[i][j];

        if (element == 'O') {
          final var lineArr = line[i];
          final var colArr = col[j];

          if (lineArr[0] < j && lineArr[1] > j
            && colArr[0] < i && colArr[1] > i) {
            board[i][j] = 'X';
          }
        }
      }
    }
  }
}
