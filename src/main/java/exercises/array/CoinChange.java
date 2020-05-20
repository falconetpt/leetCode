package exercises.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        final LinkedList<Integer> queue = Arrays.stream(coins).boxed()
                .sorted((a, b) -> - a.compareTo( b ))
                .collect( Collectors.toCollection( LinkedList::new ) );

        return coinChange( queue, amount, 0, 0 );
    }

    private int coinChange(LinkedList<Integer> queue, int amount, int i, int count) {
        if (queue.isEmpty()) {
            return amount > 0 ? -1 : count;
        } else if (amount == 0) {
            return count;
        } else {
            int nextCoin = queue.pollFirst();
            int cointCount = amount / nextCoin;
            return coinChange( queue, amount - cointCount * nextCoin, i + 1, count + cointCount );
        }
    }
}
