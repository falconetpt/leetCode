package dp;

import java.util.Arrays;

public class CoinChangeTest {
  public int coinChange(int[] coins, int amount) {
    final var dp = new int[amount + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;


    for(int i = 1; i <= amount; i++) {
      var min = Integer.MAX_VALUE;
      for(final var coin : coins) {
        if(i - coin < 0) continue;
        if(dp[i-coin] == Integer.MAX_VALUE) continue;
        min = Math.min(min, dp[i-coin] + 1);
      }

      dp[i] = min;
    }

    return dp[amount] == Integer.MAX_VALUE
        ? -1
        : dp[amount];
  }
}
