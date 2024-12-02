package dp;

import java.util.Arrays;
import java.util.HashSet;

public class RemoveDuplicates {
  public static int[] removeDuplicatesBase(int[] arr) {
    return Arrays.stream(arr).distinct().toArray();
  }

  public int removeDuplicates(int[] nums) {
    final var seen = new HashSet<Integer>();
    var index = 0;

    for (int i = 0; i < nums.length; i++) {
      final var num = nums[i];
      if (!seen.contains(num)) {
        seen.add(num);
        nums[index++] = num;
      }
    }

    return seen.size();
  }
}
