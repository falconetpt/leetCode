package exercises.array;

public class TimeToBuyAndSellStockTwoTimes {
  public int maxProfit(final int[] prices) {
    var max = 0;

    for (int i = prices.length - 2; i >= 0; i--) {
      max = Math.max(max, maxProfit(prices, i, prices.length) + maxProfit(prices, 0, i));
    }

    return max;
  }

  private int maxProfit(final int[] prices, final int start, final int end) {
    var max = 0;
    var min = Integer.MAX_VALUE;

    for (int i = start; i < end; i++) {
      final var element = prices[i];
      min = Math.min(min, element);
      max = Math.max(element - min, max);
    }

    return max;
  }
}
