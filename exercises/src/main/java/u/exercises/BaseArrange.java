package u.exercises;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class BaseArrange {

  // base case (1, 2) k = 3
  // base case (1, 3) k = 5
  // 2nd case (1,2,3,3) k = 3

  public boolean canArrange(int[] arr, int k) {
    Arrays.sort(arr); // O(n log n) Space O(n)
    final var maxSum = arr[arr.length - 1] + arr[arr.length - 2];

    if (maxSum < k) return false;

    final var maxMultiplier = maxSum / k;
    final var map = createMap(arr);
    
    return matchArrange(k, maxMultiplier, map, arr);
  }

  private boolean matchArrange(final int k,
                               final int maxMultiplier,
                               final Map<Integer, Integer> map,
                               final int[] arr) {
    if (map.values().stream().anyMatch(a -> a > 1)) {
      return false;
    } else {
      
      for (int i = 0; i < arr.length / 2; i++) {
        int finalI = i;
        final var match = IntStream.rangeClosed(1, maxMultiplier)
            .map(mult -> (k * mult) - arr[finalI])
            .anyMatch(map::containsKey);

        if (!match) return false;
      }
    }

    return false;
  }

  private Map<Integer, Integer> createMap(int[] arr) {
    final var result = new HashMap<Integer, Integer>();
    Arrays.stream(arr)
        .forEach(e -> result.put(e, result.getOrDefault(e, 0) + 1));
    return null;
  }
}
