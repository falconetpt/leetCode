package u.exercises;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BombEnemy {
  /**
   * [
   * ["0","E","0","0"],
   * ["E","0","W","E"],
   * ["0","E","0","0"]
   * ]
   *
   *
   */
  public int bombEnemy(String[][] grid) {
    // O nm
    final var rowDp = new int[grid.length][grid[0].length];
    final var colDp = new int[grid.length][grid[0].length];


    fillDp(grid, rowDp, colDp);

    System.out.println("colDp = " + Arrays.stream(colDp).map(Arrays::toString).collect(Collectors.joining("\n,")));
    System.out.println("rowDp = " + Arrays.stream(rowDp).map(Arrays::toString).collect(Collectors.joining("\n,")));;

    return findMax(grid, rowDp, colDp);

  }

  private int findMax(String[][] grid, int[][] rowDp, int[][] colDp) {
    var max = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j].equals("0")) max = Math.max(max, rowDp[i][j] + colDp[i][j]);
      }
    }

    return max;
  }

  private void fillDp(String[][] grid, int[][] rowDp, int[][] colDp) {
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j].equals("W")) {
          rowDp[i][j] = 0;
          colDp[i][j] = 0;
        } else if (grid[i][j].equals("E")) {
          rowDp[i][j] = 1 + rowDp[i][Math.max(0, j - 1)];
          colDp[i][j] = 1 + colDp[Math.max(0, i - 1)][j];
        } else {
          rowDp[i][j] = rowDp[i][Math.max(0, j - 1)];
          colDp[i][j] = colDp[Math.max(0, i - 1)][j];
        }
      }
    }

    System.out.println("colDp = " + Arrays.stream(colDp).map(Arrays::toString).collect(Collectors.joining("\n,")));
    System.out.println("rowDp = " + Arrays.stream(rowDp).map(Arrays::toString).collect(Collectors.joining("\n,")));;

    for (int i = grid.length- 1; i >= 0 ; i--) {
      for (int j = grid[i].length - 1; j >= 0; j--) {
        if (grid[i][j].equals("W")) {
          rowDp[i][j] = 0;
          colDp[i][j] = 0;
        } else {
          rowDp[i][j] = (j + 1 >= grid[i].length ? rowDp[i][j] : grid[i][j + 1].equals("W") ? rowDp[i][j] : rowDp[i][j + 1]);
          colDp[i][j] = (i + 1 >= grid.length ? colDp[i][j] : grid[i + 1][j].equals("W") ? colDp[i][j] : colDp[i + 1][j]);
        }
      }
    }
  }
}
