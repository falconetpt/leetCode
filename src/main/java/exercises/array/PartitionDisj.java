package exercises.array;

public class PartitionDisj {
  public int partitionDisjoint(final int[] nums) {
    final var minIndex = getMinIndex(nums);
    var maxIndex = getMaxIndex(nums,  minIndex);
    var endIndex = minIndex;
    var maxSeenIndex = maxIndex;

    for (int i = minIndex; i < nums.length; i++) {
      if (nums[i] < nums[maxIndex]) {
        maxIndex = maxSeenIndex;
        endIndex = i;
      }

      if (nums[i] > nums[maxSeenIndex]) maxSeenIndex = i;
    }

    return endIndex + 1;
  }

  private int getMaxIndex(final int[] nums, final int minIndex) {
    var maxIndex = 0;

    for (int i = 0; i < minIndex; i++) {
      if (nums[i] > nums[maxIndex]) {
        maxIndex = i;
      }
    }

    return maxIndex;
  }

  private int getMinIndex(final int[] nums) {
    var minIndex = 0;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] < nums[minIndex]) minIndex = i;
    }

    return minIndex;
  }
}
