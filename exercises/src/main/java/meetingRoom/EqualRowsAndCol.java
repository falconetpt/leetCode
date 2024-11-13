package meetingRoom;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class EqualRowsAndCol {
  public int equalPairs(int[][] grid) {
    final var set = getRows(grid);

    var count = 0;

    for (int i = 0; i < grid[0].length; i++) {
      final var sb = new StringBuilder();
      for (int j = 0; j < grid.length; j++) {
        final var value = grid[j][i];
        sb.append(value + ",");
      }
      if (set.containsKey(sb.toString())) count += set.get(sb.toString());
    }

    return count;
  }

  private HashMap<String, Integer> getRows(int[][] grid) {
    final var result = new HashMap<String, Integer>();

    for (int i = 0; i < grid.length; i++) {
      final var sb = new StringBuilder();
      for (int j = 0; j < grid[i].length; j++) {
        final var value = grid[i][j];
        sb.append(value + ",");
      }

      final var row = sb.toString();
      result.put(row, result.getOrDefault(row, 0) + 1);
    }

    return result;
  }
}
