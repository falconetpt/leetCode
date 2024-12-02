package dp;

import java.util.ArrayList;
import java.util.LinkedList;

public class NiceSubArr {
  public int longestNiceSubarray(int[] nums) {
    var pivot = new LinkedList<Integer>();
    pivot.add(nums[0]);
    var right = 1;
    var result = 1;

    while (right < nums.length) {
      final var element = nums[right];
      if (pivot.stream().allMatch(i -> (element & i) == 0)) {
        right++;
        pivot.add(element);
      } else {
        pivot.pollFirst();
      }

      result = Math.max(result, pivot.size());
    }


    return result;
  }
}
