package exercises.array;

public class NumRollsToTarget {
  public int numRollsToTarget(final int n,
                              final int k,
                              final int target) {
    final var result = new int[target + 2];

    for (int i = 0; i < n; i++) {
      for (int j = 1; j <= k; j++) {
        for (int l = 0; l < result.length; l++) {
          result[l + j] += 1;
        }
      }
    }

    return result[target + 1];
  }
}
