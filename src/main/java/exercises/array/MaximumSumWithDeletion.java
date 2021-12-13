package exercises.array;

public class MaximumSumWithDeletion {
  public int maximumSum(final int[] arr) {
    var result = 0;
    var sum = 0;
    var minSeen = Integer.MAX_VALUE;
    var max = Integer.MIN_VALUE;

    for (final var num : arr) {
      sum += num;
      max = Math.max(max, num);
      minSeen = Math.min(num, minSeen);
      final var localSum = Math.max(sum, sum - minSeen);
      result = Math.max(result, localSum);

      if (localSum < 0) {
        minSeen = Integer.MAX_VALUE;
        sum = 0;
      }
    }

    return max < 0
      ? max
      : result;
  }
}
