package exercises.array;

public class MaxProfit {
  public int maxProfit(final int[] prices) {
    var min = Integer.MAX_VALUE;
    var profit = 0;

    for (int i = 0; i < prices.length; i++) {
      final var element = prices[i];
      profit = Math.max(element - min, profit);
      min = Math.min(min, element);
    }

    return profit;
  }
}
