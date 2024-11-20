package finalPrep;

public class ShortestSubArraySum {
  public int shortestSubarray(int[] nums, int k) {
    if(nums.length == 1) return nums[0] >= k
        ? 1
        : -1;
    final var deltaArr = createDeltaArr(nums);
    var min = Integer.MAX_VALUE;

    for (int i = 1; i < deltaArr.length; i++) {
      if (deltaArr[i] >= k) {
        min = Math.min(getMinLeft(nums, i, k), min);
      }
    }

    return min == Integer.MAX_VALUE
        ? -1
        : min;
  }

  private int getMinLeft(int[] nums, int index, int target) {
    var sum = 0;

    for (int j = index; j >= 0; j--) {
      sum += nums[j];
      if (sum >= target) return index - j;
    }

    return Integer.MAX_VALUE;
  }

  private int[] createDeltaArr(int[] nums) {
    final var result = new int[nums.length + 1];
    var sum = 0;

    for (int i = 1; i < result.length; i++) {
      sum += nums[i - 1];
      result[i] = sum;
    }

    return result;
  }
}
