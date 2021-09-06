package exercises.array;

public class ProductExceptSelf {
  public int[] productExceptSelf(final int[] nums) {
    final var start = new int[nums.length + 1];
    final var end = new int[nums.length + 1];
    start[0] = 1;
    end[nums.length] = 1;

    for (var i = 0; i < nums.length; i++) {
      start[i + 1] = start[i] * nums[i];
      end[nums.length - i - 1] = end[nums.length - i] * nums[nums.length - 1 -i];
    }

    final var result = new int[nums.length];

    for (int i = 0; i < nums.length; i++) {
      result[i] = start[i] * end[i + 1];
    }

    return result;
  }
}
