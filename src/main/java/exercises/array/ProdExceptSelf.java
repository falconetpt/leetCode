package exercises.array;

public class ProdExceptSelf {
  public int[] productExceptSelf(final int[] nums) {
    final var left = new int[nums.length + 1];
    final var right = new int[nums.length + 1];
    left[0] = 1;
    right[nums.length] = 1;

    for (int i = 0; i < nums.length; i++) {
      left[i + 1] = left[i] * nums[i];
      right[nums.length - i - 1] = right[nums.length - i] * nums[nums.length - i - 1];
    }

    final var result = new int[nums.length];

    for (int i = 0; i < nums.length; i++) {
      result[i] = left[i] * right[i + 1];
    }

    return result;
  }
}
