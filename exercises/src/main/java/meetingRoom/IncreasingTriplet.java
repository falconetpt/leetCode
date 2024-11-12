package meetingRoom;

public class IncreasingTriplet {
  public boolean increasingTriplet(int[] nums) {
    int left = 0;
    int right = nums.length - 1;

    return search(nums, left, right);
  }

  private boolean search(int[] nums, int left, int right) {
    if (right - left > 2) {
      final var leftValue = nums[left];
      final var rightValue = nums[right];

      final var isGreater = rightValue > leftValue && canFind(nums, left, right, leftValue, rightValue);

      return isGreater || search(nums, left + 1, right) || search(nums, left, right - 1);
    } else {
      return false;
    }
  }

  private boolean canFind(int[] nums, int left, int right, int leftValue, int rightValue) {

    for (int i = left + 1; i < right; i++) {
      final var element = nums[i];
      if (element > leftValue && element < rightValue) return true;
    }

    return false;
  }
}
