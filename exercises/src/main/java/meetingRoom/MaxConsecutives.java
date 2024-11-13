package meetingRoom;

import java.util.HashSet;
import java.util.TreeSet;

public class MaxConsecutives {
  public int longestOnes(int[] nums, int k) {
    var max = 0;
    final var flipped = new TreeSet<Integer>();
    var left = 0;
    var right = 0;

    while (left < nums.length && right < nums.length) {
      if (nums[right] == 1) {
        right++;
      } else {
        if (flipped.size() == k) {

          if (flipped.ceiling(left) == null) {
            left = right+1;
          } else {
            left = flipped.ceiling(left);
            flipped.remove(left);
            flipped.add(right);
            left++;
          }
        } else {
          flipped.add(right);
        }
        right++;

      }

      max = Math.max(right - left, max);
    }

    return max;
  }
}
