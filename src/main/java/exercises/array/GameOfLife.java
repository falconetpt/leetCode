package exercises.array;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class GameOfLife {
  private final static List<Point> MOVES = List.of(
    new Point(1, 0),
    new Point(-1, 0),
    new Point(0, 1),
    new Point(0, -1),
    new Point(1, 1),
    new Point(-1, 1),
    new Point(1, -1),
    new Point(-1, -1)
  );

  public void gameOfLife(final int[][] board) {
    final var clonedBoard = Arrays.stream(board).map(int[]::clone).toArray(int[][]::new);

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        final var point = new Point(i, j);
        final var value = clonedBoard[i][j];
        final var liveCount = countNeighbors(clonedBoard, point, 1);
        System.out.println("String.format(\"x: %s, y: %s\", i, k) = " + String.format("x: %s, y: %s, value: %s", i, j, value));

        if (value == 1) {
          board[i][j] = liveCount > 1 && liveCount < 4
            ? 1
            : 0;
        } else {
          board[i][j] = liveCount == 3
            ? 1
            : 0;
        }
      }
    }
  }

  private int countNeighbors(final int[][] board, final Point point, final int searchValue) {
    return (int) MOVES.stream()
      .map(p -> new Point(point.x + p.x, point.y + p.y))
      .filter(p -> validPoint(board, p, searchValue))
      .count();
  }

  private boolean validPoint(final int[][] board, final Point p, final int searchValue) {
    try {
      return board[p.x][p.y] == searchValue;
    } catch (final ArrayIndexOutOfBoundsException e) {
      return false;
    }
  }
}

//  Any live cell with fewer than two live neighbors dies as if caused by under-population.
//  Any live cell with two or three live neighbors lives on to the next generation.
//  Any live cell with more than three live neighbors dies, as if by over-population.
//  Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
