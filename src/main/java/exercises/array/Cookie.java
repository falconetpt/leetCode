package exercises.array;

import java.util.Arrays;

public class Cookie {
  public int distributeCookies(int[] cookies, int k) {
    final var avg = Arrays.stream(cookies)
        .reduce(0, Integer::sum);
    Arrays.sort(cookies);
    final var max = Integer.MIN_VALUE;
    return 1;
  }
}
