package dp;

import java.util.HashMap;

/*

465. Optimal Account Balancing

A group of friends went on holiday and sometimes lent each other money. For example, Alice paid for Bill's lunch for $10. Then later Chris gave Alice $5 for a taxi ride. We can model each transaction as a tuple (x, y, z) which means person x gave person y $z. Assuming Alice, Bill, and Chris are person 0, 1, and 2 respectively (0, 1, 2 are the person's ID), the transactions can be represented as [[0, 1, 10], [2, 0, 5]].

Given a list of transactions between a group of people, return the minimum number of transactions required to settle the debt.

Note:

    A transaction will be given as a tuple (x, y, z). Note that x ≠ y and z > 0.
    Person's IDs may not be linear, e.g. we could have the persons 0, 1, 2 or we could also have the persons 0, 2, 6.

0 -> 1 : 10
2 -> 0: 5

0: 5
1: -10
2: 5

Example 1:

Input:
[[0,1,10], [2,0,5]]

Output:
2

Explanation:
Person #0 gave person #1 $10.
Person #2 gave person #0 $5.

Two transactions are needed. One way to settle the debt is person #1 pays person #0 and #2 $5 each.

Example 2:

Input:
[[0,1,10], [1,0,1], [1,2,5], [2,0,5]]

0 -> 1: 10
1 -> 0: 1
1 -> 2: 5
2 -> 0: 5


0: 10 - 1 - 5 = +4
1: 1 + 5 - 10 = -4
2: -5 + 5 = 0


Output:
1

Explanation:
Person #0 gave person #1 $10.
Person #1 gave person #0 $1.
Person #1 gave person #2 $5.
Person #2 gave person #0 $5.

Therefore, person #1 only need to give person #0 $4, and all debt is settled.

 */
public class BalanceCheck {
  public int payback(int[][] transactions) {
    final var map = new HashMap<Integer, Integer>();

    for (final var transaction : transactions) {
      final var origin = transaction[0];
      final var destination = transaction[1];
      final var pay = transaction[2];

      map.put(origin, map.getOrDefault(origin, 0) + pay);
      map.put(destination, map.getOrDefault(destination, 0) - pay);
    }

    return (int) (map.values().stream()
            .filter(v -> v != 0)
            .count() - 1);
  }
}
