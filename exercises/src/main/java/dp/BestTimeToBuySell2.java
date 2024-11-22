package dp;

public class BestTimeToBuySell2 {
  public int maxProfit(int[] prices) {
    var min = Integer.MAX_VALUE;
    var profit = 0;

    for (final var price : prices) {
      if (price - min < 0) {
        min = Math.min(price, min);
      } else {
        profit += Math.max(price - min, 0);
        min = price;
      }
    }

    return profit;
  }
}
