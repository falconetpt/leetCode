package exercises.array;

public class TimeToBuyAndSellStockTwoTimes {
  public int maxProfit(int[] prices) {
    int n = prices.length;
    if (n == 0) return 0;

    int[] left = new int[n];
    int[] right = new int[n];

    int minLeft = prices[0];
    for (int i = 1; i < n; i++) {
      left[i] = Math.max(left[i - 1], prices[i] - minLeft);
      minLeft = Math.min(minLeft, prices[i]);
    }

    int maxRight = prices[n - 1];
    for (int i = n - 2; i >= 0; i--) {
      right[i] = Math.max(right[i + 1], maxRight - prices[i]);
      maxRight = Math.max(maxRight, prices[i]);
    }

    int maxProfit = 0;
    for (int i = 0; i < n; i++) {
      maxProfit = Math.max(maxProfit, left[i] + right[i]);
    }

    return maxProfit;
  }
}
