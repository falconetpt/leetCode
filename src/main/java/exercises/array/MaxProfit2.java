package exercises.array;

public class MaxProfit2 {
  public int maxProfit(final int[] prices) {
    final var result = new int[prices.length + 1];

    for (int i = prices.length - 1; i >= 0 ; i--) {
      final var element = prices[i];
      var max = 0;

      for (int j = i + 1; j < prices.length; j++) {
        max = Math.max(max, prices[j] - element + result[j + 1]);
      }

      result[i] = Math.max(max, result[i+1]);
    }

    return result[0];
  }
}
