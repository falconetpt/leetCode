package dp;

import java.util.LinkedList;

public class FindMedian {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    final var totalSize = nums1.length + nums2.length;
    final var midPoint = totalSize / 2 + 1;
    final var isEven = totalSize % 2 == 0;
    final var pq = new LinkedList<Integer>();
    var num1Pointer = 0;
    var num2Pointer = 0;

    for (int i = 0; i <= totalSize; i++) {
      if (num1Pointer < nums1.length && num2Pointer < nums2.length) {
        if (nums1[num1Pointer] < nums2[num2Pointer]) {
          pq.add(nums1[num1Pointer++]);
        } else {
          pq.add(nums2[num2Pointer++]);
        }
      } else {
        final var value = num2Pointer >= nums2.length
            ? nums1[num1Pointer++]
            : nums2[num2Pointer++];
        pq.add(value);
      }

      // System.out.println(pq);
      if (pq.size() == midPoint) {
        return isEven
            ? (pq.pollLast() + pq.pollLast()) / 2.0
            : pq.pollLast();
      }
    }

    return 0;
  }
}
