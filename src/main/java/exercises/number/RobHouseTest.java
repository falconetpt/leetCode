package exercises.number;

public class RobHouseTest {
  public int rob(final int[] nums) {
    final var result = new int[nums.length + 2];
    
    for (var i = nums.length - 1; i >= 0; i--) {
      result[i] = Math.max(nums[i] + result[i + 2], result[i + 1]);
    }
    
    return result[0];
  }
}
