package exercises.string;

public class SearchInsert {
  public int searchInsert(final int[] nums, final int target) {
    var begining = 0;
    var end = nums.length - 1;

    while (begining != end) {
      final var mid = (begining + end) / 2;
      final var value = nums[mid];

      if(value == target) return mid;

      if (value > target) {
        end = Math.max(begining, mid - 1);
      } else {
        begining = Math.min(nums.length - 1, mid + 1);
      }
    }

    return nums[begining] >= target
      ? begining
      : begining + 1;
  }
}
