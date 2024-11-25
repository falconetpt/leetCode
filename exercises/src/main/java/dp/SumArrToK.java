package dp;

import java.util.HashMap;

public class SumArrToK {
  public int maxProduct(int[] nums) {
    if (nums.length == 1) return nums[0];
    var max = 0;

    // O(n^2)
    for(int i = 0; i < nums.length; i++) {
      var result = nums[i];
      max = Math.max(result, max);
      for (int j = i + 1; j < nums.length; j++) {
        result *= nums[j];
        max = Math.max(result, max);
      }
    }

    return max;
  }
}
