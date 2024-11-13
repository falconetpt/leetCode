package meetingRoom;

public class LongestSubarray {
  public int longestSubarray(int[] nums) {
    var left = 0;
    var right = 0;
    var max = 0;
    var eliminated = -1;

    while (left < nums.length && right < nums.length) {
      final var element = nums[right];

      if (element == 0) {
        if (eliminated == -1) {
          eliminated = right;
        } else {
          left = eliminated + 1;
          eliminated = right;
        }
      }

      max = Math.max(max, right - left);

      right++;
    }


    return max;
  }
}
