package exercises.array;

public class JumpGame {
  public boolean canJump(int[] nums) {
    final var result = new boolean[nums.length];
    result[nums.length - 1] = true;

    for(int i = nums.length - 2; i >= 0; i--) {
      final var jump = nums[i];
      var canJump = false;
      for(int j = i + 1; j < Math.min(i + jump + 1, nums.length); j++) {
        if (result[j]) canJump = true;
      }

      result[i] = canJump;
    }


    return result[0];
  }
}
