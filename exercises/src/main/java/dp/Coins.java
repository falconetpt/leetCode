package dp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Coins {
  public int coinChange(int[] coins, int amount) {
    final Comparator<Integer> comparator = Comparator.comparing(a -> -a);
    final var list = Arrays.stream(coins)
        .boxed()
        .sorted(comparator)
        .toList();

    final var min = coinChange(list, 0, amount, new HashMap<>());

    return min == Integer.MAX_VALUE
        ? -1
        : min;
  }

  private int coinChange(List<Integer> queue, int i, int amount,
                         HashMap<Integer, Integer> min) {
    if (amount == 0) return 0;

    if (i >= queue.size()) return -1;

    final var nextCoin = queue.get(i);
    final var maxCoins = amount / nextCoin;

    for (int j = maxCoins; j >= 0; j--) {
      final var remainingAmount = amount - nextCoin * j;
      final var minNext = min.containsKey(remainingAmount)
        ? min.get(remainingAmount)
      : coinChange(queue, i + 1, remainingAmount, min);

      // System.out.println("Min next:" + minNext + ", remainingAmount:" + remainingAmount +",amount:" + amount + ",max coins:" + j + ",coin:" + nextCoin);
      if(minNext != -1) {
        min.putIfAbsent(amount, j + minNext);
        min.put(amount, Math.min(minNext + j, min.get(amount)));
      }

    }

    // System.out.println(min);


    return min.getOrDefault(amount, -1);
  }
}
