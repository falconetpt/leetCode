package exercises.blind;

public class RobHouser {
  public int rob(final int[] nums) {
    final var result = new int[nums.length + 2];

    for (int i = nums.length - 1; i >= 0; i--) {
      final var element = nums[i];
      result[i] = Math.max(result[i + 1], element + result[i + 2]);
    }

    return result[0];
  }
}
