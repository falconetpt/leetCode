package dp;

public class ProductExceptSelf {
  public int[] productExceptSelf(int[] nums) {
    final var left = generateLeftArr(nums);
    final var right = generateRightArr(nums);


    final var result = new int[nums.length];


    for (int i = 1; i < nums.length + 1; i++) {
      result[i - 1] = left[i - 1] * right[i];
    }

    return result;
  }

  private int[] generateRightArr(int[] nums) {
    final var result = new int[nums.length + 1];
    result[nums.length] = 1;


    for (int i = nums.length - 1; i >= 0; i--) {
      result[i] = result[i + 1] * nums[i];
    }

    return result;
  }

  private int[] generateLeftArr(int[] nums) {
    final var result = new int[nums.length + 1];
    result[0] = 1;

    for (int i = 1; i < nums.length + 1; i++) {
      result[i] = result[i - 1] * nums[i -1];
    }

    return result;
  }
}
