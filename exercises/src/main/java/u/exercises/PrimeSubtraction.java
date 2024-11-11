package u.exercises;

import java.util.HashSet;
import java.util.TreeSet;

public class PrimeSubtraction {
  public boolean primeSubOperation(int[] nums) {
    final var primes = new HashSet<Integer>();
    primes.add(2);
    primes.add(3);

    return primeSubOperation(nums, nums.length - 1, primes, Integer.MAX_VALUE);
  }

  private boolean primeSubOperation(int[] nums, int i, HashSet<Integer> primes, int last) {
    if (i < 0) return true;
    final var num = nums[i];

    if (num < last) return primeSubOperation(nums, i - 1, primes, num);

    addsPrimes(primes, num);

    final var newPrimes = new HashSet<>(primes);

    return newPrimes
        .stream()
        .filter(p -> p < num)
        .map(p -> num - p)
        .filter(p -> p < last)
        .anyMatch(p -> primeSubOperation(nums, i - 1, primes, p));

  }

  private void addsPrimes(HashSet<Integer> primes, int num) {
    for (int i = 4; i < num; i++) {
      if(!primes.contains(i)) {
        int finalI = i;
        final var divisibleBy = primes.stream().filter(p -> finalI % p == 0)
            .count();

        if (divisibleBy == 0) primes.add(i);
      }

    }
  }
}
