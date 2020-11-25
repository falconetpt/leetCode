package exercises.array;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int minValue = Integer.MAX_VALUE;
        int maxProfit = 0;

        return maxProfit(prices, 0, minValue, maxProfit);
    }

    private int maxProfit(int[] prices, int i, int minValue, int maxProfit) {
        if (i >= prices.length) {
            return maxProfit;
        } else {
            int newMinValue = Math.min( minValue, prices[i] );
            return maxProfit(
                    prices,
                    i + 1,
                    newMinValue,
                    Math.max( maxProfit, prices[i] - newMinValue )
            );
        }
    }
}
