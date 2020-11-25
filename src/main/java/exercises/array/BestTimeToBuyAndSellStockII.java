package exercises.array;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        return IntStream.range( index, prices.length - 1 )
                .map( i -> Math.max( prices[i + 1] - prices[i], 0 ))
                .sum();
    }
}
