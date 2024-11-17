package finalPrep;

import java.util.stream.IntStream;

public class MaxKSubArray {
  public int[] resultsArray(int[] nums, int k) {
    if(nums.length == 1) return new int[] {nums[0]};
    final var count = getDeltaArray(nums);

    final var result = new int[nums.length - k + 1];
    var oneCount = IntStream.range(0, k - 1)
        .filter(i -> count[i] == 1)
        .count();

    for (int i = k - 1; i < nums.length; i++) {
      oneCount += count[i] == 1
          ? 1
          : 0;
      final var start = i - k + 1;

      if (oneCount == k || k == 1) {
        result[start] = nums[i];
      } else {
        result[start] = -1;
      }

      oneCount -= count[start] == 1
          ? 1
          : 0;

      if (start + 1 < nums.length)  {
        if (count[start + 1] == 1) oneCount -= 1;
        count[start + 1] = 1;
        oneCount++;
      }


      // System.out.println(Arrays.toString(count));
    }

    return result;
  }

  private int[] getDeltaArray(int[] nums) {
    final var result = new int[nums.length];
    result[0] = 1;

    for (int i = 1; i < nums.length; i++) {
      result[i] = nums[i] - nums[i-1];
    }

    return result;
  }
}
