package exercises.string;

public class TurbulentArray {
  public int maxTurbulenceSize(final int[] arr) {
    final var result = new int[arr.length - 1];
    var maxCount = 1;
    var count = 0;

    for (int i = 1; i < result.length; i++) {
      final var difference = arr[i] - arr[i - 1];

      if (difference > 0) {
        result[i] = result[i - 1] == 1
          ? 0
          : 1;
      } else if (difference < 0) {
        result[i] = result[i - 1] == -1
          ? 0
          : -1;
      } else {
        result[i] = 0;
      }
    }

    for (int i = 1; i < result.length; i++) {
      if (result[i] != 0) {
        count++;
      } else {
        maxCount = Math.max(count + 1, maxCount);
        count = 0;
      }
    }

    return arr.length > 1
      ? Math.max(count, Math.max(maxCount, 1))
      : arr.length;
  }
}
