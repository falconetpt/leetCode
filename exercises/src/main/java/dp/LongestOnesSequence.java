package dp;

public class LongestOnesSequence {
  public int longestOnes(int[] nums, int k) {
    var left = 0;
    var right = 0;
    var max = 0;
    var count = 0;


    while (right < nums.length) {
      if (nums[right] == 0) count++;

      while (count > k) if (nums[left++] == 0) count--;
      max = Math.max(max, right - left + 1);
      right++;
    }

    return max;
  }
}
