package dp;

public class PivotIndex {
  public int pivotIndex(int[] nums) {
    final var rightSum = new int[nums.length + 1];

    for (int i = nums.length -1; i >= 0 ; i--) {
      rightSum[i] += rightSum[i + 1] + nums[i];
    }

    var sum = 0;

    for (int i = 0; i < nums.length; i++) {
      if (sum == rightSum[i + 1]) return i;
      sum += nums[i];
    }

    return -1;
  }
}
