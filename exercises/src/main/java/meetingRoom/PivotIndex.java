package meetingRoom;

import java.util.Arrays;

public class PivotIndex {
  public int pivotIndex(int[] nums) {
    var leftSum = 0;
    var rightSum = Arrays.stream(nums).sum();

    for (int i = 0; i < nums.length; i++) {
      final var num = nums[i];
      rightSum -= num;

      if (leftSum == rightSum) return i;

      leftSum += num;
    }

    return -1;
  }
}
