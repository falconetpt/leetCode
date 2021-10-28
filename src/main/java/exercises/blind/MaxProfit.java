package exercises.blind;

public class MaxProfit {
  public int maxProfit(final int[] prices) {
    var min = Integer.MAX_VALUE;
    var profit = 0;

    for (final var element : prices) {
      min = Math.min(min, element);
      profit = Math.max(element - min, profit);
    }

    return profit;
  }
}
