package exercises.array;

import java.util.Arrays;

public class SearchNumInMatrix {
  public boolean searchMatrix(final int[][] matrix, final int target) {
    for (final int[] ints : matrix) {
      final var first = ints[0];
      final var last = ints[ints.length - 1];

      if (target >= first && target <= last) return Arrays.stream(ints)
        .anyMatch(e -> e == target);
    }

    return false;
  }
}
