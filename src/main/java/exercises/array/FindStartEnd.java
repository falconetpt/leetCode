package exercises.array;

public class FindStartEnd {
  public int[] searchRange(final int[] nums, final int target) {
    return searchRange(nums, target, 0, nums.length - 1);
  }

  private int[] searchRange(final int[] nums, final int target,
                            final int start, final int end) {
    if (start > 0) {
      return new int[] { -1, -1 };
    } else {
      final var mid = (start + end) / 2;

      if (nums[mid] == target) {
        var newStart = mid;
        var newEnd = mid;

        while (newStart >= 0 && newEnd < nums.length) {
          final var startValue = nums[newStart];
          final var endValue = nums[newEnd];

          if (startValue != target) {
            if (endValue != target) {
              newStart++;
              newEnd--;
              return new int[] {newStart, newEnd};
            }
          }

          if (endValue == target) newEnd++;
          if (startValue == target) newStart--;
        }

        return new int[] {newStart, newEnd};

      } else if (nums[mid] > target) {
        return searchRange(nums, target, start, mid - 1);
      } else {
        return searchRange(nums, target, mid + 1,  end);
      }
    }
  }
}
