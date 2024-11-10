package u.exercises;

import java.util.ArrayList;

public class Factors {
  public int kthFactor(int n, int k) {
    final var list = new ArrayList<Integer>();

    for (int i = 1; i <= n; i++) {
      if (n % i == 0) list.add(i);
      if (list.size() == k) return list.get(k-1);
    }

    return -1;
  }
}
