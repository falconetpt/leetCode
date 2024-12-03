package dp;

public class SearchInRotatedArr {
  public int search(int[] nums, int target) {
    final var pivotIndex = findPivotIndex(nums, 0, nums.length -1);

    return binarySearch(nums, pivotIndex, pivotIndex + nums.length, target);
  }

  public int binarySearch(int[] nums, int start, int end, int target) {
    if (start == end) return nums[start % nums.length] == target
        ? start
        : -1;

    final var mid = (start + end) / 2;

    final var midElement = nums[mid % nums.length];

    if (midElement == target) return mid % nums.length;

    if (target > midElement) return binarySearch(nums, mid + 1, end, target);
    return binarySearch(nums, start, mid, target);
  }

  public int findPivotIndex(int[] nums, int start, int end) {
    if(start == end) return start;
    final var mid = (start + end) / 2;

    final var startNum = nums[start];
    final var midNum = nums[mid];
    final var endNum = nums[end];

    if (startNum < endNum) return start;
    if(midNum < startNum) return findPivotIndex(nums, start, mid);
    return findPivotIndex(nums, mid + 1, end);
  }
}
