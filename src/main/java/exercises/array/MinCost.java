package exercises.array;

public class MinCost {
  public int minCost(final String s, final int[] cost) {
    var result = Integer.MAX_VALUE;

    for (int i = 0; i < s.length(); i++) {
      var localResult = 0;
      final var element = s.charAt(i);
      for (int j = i + 1; j < s.length(); j++) {

      }
    }

    return result == Integer.MAX_VALUE
      ? 0
      : result;
  }
}
