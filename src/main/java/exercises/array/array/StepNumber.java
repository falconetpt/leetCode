package exercises.array.array;

public class StepNumber {
  public int climbStairs(final int n) {
    if (n < 2) return n;

    final var ways = new int[n + 1];
    ways[0] = 0;
    ways[1] = 1;
    ways[2] = 1;

    for (int i = 2; i < ways.length; i++) {
      ways[i] += ways[i - 1] + ways[i - 2];
    }

    return ways[ways.length - 1];
  }
}
