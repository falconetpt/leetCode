package exercises.array;

public class MinOverlappingArray {
  public int minSumOfLengths(final int[] arr, final int target) {
    final var result = new int[] { Integer.MAX_VALUE, Integer.MAX_VALUE };

    for (int i = 0; i < arr.length; i++) {
      var sum = arr[i];
      var count = 1;
      for (int j = i + 1; j < arr.length && sum + arr[j] <= target; j++) {
        sum += arr[j];
        count++;
      }

      if (sum == target) {
        if (result[0] > count) {
          result[1] = result[0];
          result[0] = count;
        } else if (result[1] > count) {
          result[1] = count;
        }
      }
    }

    return arr[0] + arr[1];
  }
}
