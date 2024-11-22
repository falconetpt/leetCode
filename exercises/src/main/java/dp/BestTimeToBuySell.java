package dp;

public class BestTimeToBuySell {
  public int maxProfit(int[] prices) {
    var min = Integer.MAX_VALUE;
    var profit = 0;

    for (final var price : prices) {

      min = Math.min(min, price);

      profit = Math.max(price - min, profit);
    }

    return profit;
  }
}
