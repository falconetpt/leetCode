package u.exercises;

public class MaxSubArr {
  public int maxSubArray(int[] nums) {
    if(nums.length == 1) return nums[0];
    var pointer = 1;
    var prevValue = nums[0];
    var max = prevValue;

    while(pointer < nums.length) {
      final var value = nums[pointer];
      final var newValue = Math.max(value + prevValue, value);
      max = Math.max(newValue, max);

      if(newValue < prevValue && newValue < 0) {
        prevValue = 0;
      } else {
        prevValue = newValue;
      }

      pointer++;
    }

    return max;
  }
}
