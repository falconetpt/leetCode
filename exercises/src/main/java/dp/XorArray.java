package dp;

import java.util.stream.IntStream;

public class XorArray {
  public int[] xorQueries(int[] arr, int[][] queries) {
    final var result = new int[queries.length];

    for(int i = 0; i < queries.length; i++) {
      final var query = queries[i];
      result[i] = IntStream.rangeClosed(query[0], query[1])
          .map(index -> arr[index])
          .reduce( (a, b) -> a ^ b)
          .orElse(arr[query[0]]);
    }

    return result;
  }
}
