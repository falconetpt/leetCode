package exercises.array;

public class RotateArrayByK {
  public void rotate(int[] nums, int k) {
    final var newK = k % nums.length;
    final var copy = nums.clone();

    for (int i = 0; i < nums.length; i++) {
      nums[i] = copy[(nums.length - newK + i) % nums.length];
    }
  }
}
