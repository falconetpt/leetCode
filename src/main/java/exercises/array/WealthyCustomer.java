package exercises.array;

import java.util.Arrays;
import java.util.Comparator;

public class WealthyCustomer {
  public int maximumWealth(int[][] accounts) {
    return Arrays.stream(accounts)
      .map(i -> Arrays.stream(i).sum())
      .max(Comparator.comparingInt(i -> i))
      .orElse(Integer.MIN_VALUE);
  }
}
