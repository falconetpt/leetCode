package exercises.array;

public class RobHouses {
  public int rob(final int[] nums) {
    final var maxValue = new int[nums.length + 1];
    maxValue[1] = nums[0];

    for (int i = 1; i < nums.length; i++) {
      final var sumValue = nums[i]
        + maxValue[i + 1 - 2];
      maxValue[i + 1] = Math.max(maxValue[i], sumValue);
    }

    return maxValue[nums.length];
  }
}
