package exercises.array;

import java.awt.*;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CreateSpiral {
  private final LinkedList<Point> MOVES = Stream.of(
    new Point(0, 1),
    new Point(1, 0),
    new Point(0, -1),
    new Point(-1, 0)
  ).collect(Collectors.toCollection(LinkedList::new));

  public int[][] generateMatrix(final int n) {
    final var board = new int[n][n];

    generateMatrix(board, new Point(0, 0), 1,n * n);

    return board;
  }

  private void generateMatrix(final int[][] board,
                              final Point point,
                              final int nextNum,
                              final int stepsLeft) {
    if (stepsLeft > 0) {
      System.out.println(stepsLeft);
      board[point.x][point.y] = nextNum;
      var nextMove = MOVES.peekFirst();
      var nextPoint = new Point(nextMove.x + point.x, nextMove.y + point.y);

      if (!validPoint(board, nextPoint)) {
        MOVES.addLast(MOVES.pollFirst());
        nextMove = MOVES.peekFirst();
        nextPoint = new Point(nextMove.x + point.x, nextMove.y + point.y);
      }

      generateMatrix(board, nextPoint, nextNum + 1, stepsLeft - 1);
    }
  }

  private boolean validPoint(final int[][] board, final Point point) {
    try {
      return board[point.x][point.y] == 0;
    } catch (final IndexOutOfBoundsException e) {
      return false;
    }
  }
}
