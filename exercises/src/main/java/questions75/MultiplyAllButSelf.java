package questions75;

public class MultiplyAllButSelf {
  public int[] productExceptSelf(int[] nums) {
    final var left = new int[nums.length ];
    final var right = new int[nums.length];
    fillLeft(nums, left);
    fillRight(nums, right);

    final var result = new int[nums.length];

    for (int i = 0; i < right.length; i++) {
      final var leftValue = i - 1 < 0
          ? 1
          : left[i-1];
      final var rightValue = i + 1 >= nums.length
          ? 1
          : right[i + 1];
      result[i] = leftValue * rightValue;
    }

    return result;
  }

  private void fillRight(int[] nums, int[] right) {
    int previous = 1;
    for (int i = nums.length - 1; i >= 0 ; i--) {
      right[i] = previous * nums[i];
      previous = right[i];
    }
  }

  private void fillLeft(int[] nums, int[] left) {
    int previous = 1;

    for (int i = 0; i < left.length; i++) {
      left[i] =  previous * nums[i];
      previous = left[i];
    }

  }
}
