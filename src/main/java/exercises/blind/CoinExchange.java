package exercises.blind;

import java.util.Arrays;

public class CoinExchange {
  public int coinChange(final int[] coins, final int amount) {
    if(amount == 0) return 0;
    final var coinDp = new int[amount + 1];
    coinDp[0] = -1;

    Arrays.stream(coins)
      .filter(c -> c <= amount)
      .forEach(c -> coinDp[c] = 1);


    for (int i = 1; i < coinDp.length; i++) {
      var localCoin = Integer.MAX_VALUE;

      for (int j = 1; j <= i / 2; j++) {
        final var start = coinDp[j];
        final var end = coinDp[i- j];

        if (start != -1 && end != -1) localCoin = Math.min(localCoin, start + end);

      }

      if (coinDp[i] == 0) {
        coinDp[i] = localCoin == Integer.MAX_VALUE
          ? - 1
          : localCoin;
      }
    }

    return coinDp[amount];
  }
}
