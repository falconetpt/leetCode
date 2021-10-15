package exercises.array;

public class TimeToBuyAndSellStockWithCooldown {
  public int maxProfit(final int[] prices) {
    final var result = new int[prices.length + 2];

    for (int i = prices.length - 2; i >= 0; i--) {
      int max = 0;
      final var buyPrice = prices[i];
      for (int j = i + 1; j < prices.length; j++) {
        final var sellPrice = prices[j];

        max = Math.max(Math.max(sellPrice - buyPrice, 0) + result[j + 2], max);
        max = Math.max(max, Math.max(result[j], result[j + 1]));
      }
      result[i] = max;
    }

    return result[0];
  }
}
