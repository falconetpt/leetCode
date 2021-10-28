package exercises.array;

import java.util.Arrays;

public class SortColor {
  public void sortColors(final int[] nums) {
    final var map = new int[3];
    Arrays.stream(nums).forEach(i -> map[i]++);

    var start = 0;

    for (int i = 0; i < nums.length; i++) {
      var count = map[start];
      while (count == 0) {
        start++;
        count = map[start];
      }
      nums[i] = start;
      map[start]--;
    }

  }
}
