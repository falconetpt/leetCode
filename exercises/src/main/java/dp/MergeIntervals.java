package dp;

import java.util.stream.IntStream;

public class MergeIntervals {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    final var finalNums = new int[m + n];
    var leftIndex = 0;
    var rightIndex = 0;

    while (leftIndex < m || rightIndex < n) {
      if (leftIndex < m && rightIndex < n) {
        if (nums1[leftIndex] < nums2[rightIndex]) {
          finalNums[leftIndex + rightIndex] = nums1[leftIndex];
          leftIndex++;
        } else {
          finalNums[leftIndex + rightIndex] = nums2[rightIndex];
          rightIndex++;
        }
      } else if (leftIndex < m) {
        finalNums[leftIndex + rightIndex] = nums1[leftIndex];
        leftIndex++;
      } else {
        finalNums[leftIndex + rightIndex] = nums2[rightIndex];
        rightIndex++;
      }
    }

    IntStream.range(0, finalNums.length).forEach(i -> nums1[i] = finalNums[i]);
  }
}
