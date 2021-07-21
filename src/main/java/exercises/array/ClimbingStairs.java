package exercises.array;

public class ClimbingStairs {
  public int climbStairs(int n) {
    final var cache = new int[n];

    fillArray(cache, 0);

    return cache[0];
  }

  private int fillArray(final int[] cache, final int i) {
    if (i >= cache.length) {
      return i == cache.length ? 1 : 0;
    } else if (cache[i] > 0) {
      return cache[i];
    } else {
      cache[i] = fillArray(cache, i + 1) + fillArray(cache, i + 2);
      return cache[i];
    }
  }
}
