package u.exercises;

public class CountNegatives {
  public int countNegatives(int[][] grid) {
    int lastSeen = 0;
    int count = 0;

    for (int i = 0; i < grid.length; i++) {
      var lastElementIndex = grid[i].length - 1 - lastSeen;
      while (lastElementIndex > 1 && grid[i][lastElementIndex -1] < 0) lastSeen++;
      count += lastSeen;
    }

    return count;
  }
}
