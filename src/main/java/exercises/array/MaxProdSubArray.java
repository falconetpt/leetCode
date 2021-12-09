package exercises.array;

public class MaxProdSubArray {
  public int maxProduct(final int[] nums) {
    var max = 0;

    for (int i = 0; i < nums.length; i++) {
      var localValue = nums[i];

      for (int j = i + 1; j < nums.length; j++) {
        localValue *= nums[j];
      }

      max = Math.max(max, localValue);
    }

    return max;
  }
}
