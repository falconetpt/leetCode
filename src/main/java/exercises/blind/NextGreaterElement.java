package exercises.blind;

import java.util.TreeMap;

public class NextGreaterElement {
  public int[] nextGreaterElement(final int[] nums1, final int[] nums2) {
    final var bottomValue = new TreeMap<Integer, Integer>();
    final var result = new int[nums1.length];

    for (int i = 0; i < nums2.length; i++) {
      bottomValue.putIfAbsent(nums2[i], i);
    }


    for (int i = 0; i < nums1.length; i++) {
      final var num = nums1[i];
      final var index = bottomValue.get(num);
      result[i] = findNext(nums2, num, index);
    }

    return result;
  }

  private int findNext(int[] nums, int num, int index) {
    for (int j = index + 1; j < nums.length; j++) {
      if (nums[j] > num) return  nums[j];
    }

    return -1;
  }
}
