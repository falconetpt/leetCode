package exercises.array;

import java.util.Arrays;

public class KthLargest {
  public int findKthLargest(int[] nums, int k) {
    Arrays.sort(nums);
    return nums[nums.length - k];
  }
}
