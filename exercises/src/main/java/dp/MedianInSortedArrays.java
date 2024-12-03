package dp;

import java.util.LinkedList;

public class MedianInSortedArrays {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    final var totalSize = nums1.length + nums2.length;
    final var middle = totalSize / 2;
    final var linkedList = new LinkedList<Integer>();

    var num1Index = 0;
    var num2Index = 0;

    while ( num1Index + num2Index <= middle) {
      final var num1Local = num1Index < nums1.length
          ? nums1[num1Index]
          : Integer.MAX_VALUE;
      final var num2Local = num2Index < nums2.length
          ? nums2[num2Index]
          : Integer.MAX_VALUE;

      if (num1Local > num2Local) {
        linkedList.addLast(num2Local);
        num2Index++;
      } else {
        linkedList.addLast(num1Local);
        num1Index++;
      }
    }

    if(totalSize % 2 == 0) return (linkedList.pollLast() + linkedList.pollLast()) / (double) 2.0;
    return linkedList.pollLast();
  }
}
