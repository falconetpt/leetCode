package exercises.array;

import java.awt.*;
import java.util.List;
import java.util.stream.Stream;

public class TicTacToe {
  private static final List<String> PLAYERS = List.of(
    "A",
    "B"
  );

  public String tictactoe(final int[][] moves) {
    final var board = new int[3][3];
    final var result = getResult(moves, 0, board);

    if (result == "Draw" && moves.length < 9) {
      return "Pending";
    } else {
      return result;
    }
  }

  private String getResult(final int[][] moves, final int i, final int[][] board) {
    if (i >= moves.length) {
      return "Draw";
    } else {
      final var element = moves[i];
      final var player = (i % 2);
      board[element[0]][element[1]] = player + 1;

      return isWin(board, player + 1)
        ? PLAYERS.get(player)
        : getResult(moves, i + 1, board);
    }
  }

  private boolean isWin(final int[][] board, final int player) {
    return winRow(board, player)
      || winColumn(board, player)
      || winDiagonal(board, player);
  }

  private boolean winDiagonal(final int[][] board, final int player) {
    return Stream.of(new Point(0, 0), new Point(1, 1), new Point(2, 2))
      .allMatch(p -> board[p.x][p.y] == player)
      || Stream.of(new Point(2, 0), new Point(1, 1), new Point(0, 2))
      .allMatch(p -> board[p.x][p.y] == player);
  }

  private boolean winColumn(final int[][] board, final int player) {
    for (int i = 0; i < board.length; i++) {
      var count = 0;
      for (int j = 0; j < board[i].length; j++) {
        if (board[j][i] == player) count++;
      }

      if (count == board.length) return true;
    }

    return false;
  }

  private boolean winRow(final int[][] board, final int player) {
    for (int i = 0; i < board.length; i++) {
      var count = 0;
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == player) count++;
      }

      if (count == board.length) return true;
    }

    return false;
  }
}
