package exercises.blind;

import java.util.Arrays;

public class MaximumProductSubArray {
  public int maxProduct(final int[] nums) {
    int result = Integer.MIN_VALUE;

    for (int i = 0; i < nums.length; i++) {
      int resultLocal = 1;

      for (int j = i; j < nums.length; j++) {
        resultLocal *= nums[j];
        result = Math.max( result, resultLocal );
      }
    }

    return result;
  }
}
