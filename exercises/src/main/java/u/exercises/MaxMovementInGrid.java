package u.exercises;

import java.awt.Point;
import java.util.List;
import java.util.stream.IntStream;

public class MaxMovementInGrid {
  private static final List<Point> MOVES = List.of(
      new Point(-1, 1),
      new Point(0, 1),
      new Point(1, 1)
  );

  public int maxMoves(int[][] grid) {
    final var newGrid = new int[grid.length][grid[0].length];

    fillGrid(grid, newGrid);

    return IntStream.range(0, grid.length)
        .map(i -> newGrid[i][0])
        .max()
        .orElse(0);
  }

  private void fillGrid(int[][] grid, int[][] newGrid) {
    final var twoColumnsFromEnd = grid[0].length - 2; // Last column is always 0 since it can't connect with anything else
    for (int col = twoColumnsFromEnd; col >= 0; col--) {
      for (int row = 0; row < grid.length; row++) {
        int finalRow = row;
        int finalCol = col;
        final int value = grid[row][col];
        newGrid[row][col] = MOVES.stream()
            .map(p -> new Point(p.x + finalRow, p.y + finalCol))
            .filter(p -> p.x < grid.length && p.y < grid[finalRow].length)
            .filter(p -> p.x >= 0 && p.y >= 0)
            .filter(p -> grid[p.x][p.y] > value)
            .map(p -> 1 + newGrid[p.x][p.y])
            .max(Integer::compareTo)
            .orElse(0);
      }
    }
  }
}
