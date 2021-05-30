package exercises.number;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class CoinExchange {
  public int coinChange(final int[] coins, final int amount) {
    final var dp = new int[amount + 1];

    for (var i = 1; i <= amount; i++) {
      var min = Integer.MAX_VALUE;
      for (var coin: coins) {
        if (i - coin >= 0 && dp[i - coin] != -1) {
          min = Math.min(dp[i - coin], min);
        }
        dp[i] = Integer.MAX_VALUE == min ? -1 : min + 1;
      }
    }

    return dp[amount];
  }
}
