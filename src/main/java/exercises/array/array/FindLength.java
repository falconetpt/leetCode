package exercises.array.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindLength {
  public int findLength(int[] nums1, int[] nums2) {
    final var map = new HashMap<Integer, List<Integer>>();

    for (int i = 0; i < nums1.length; i++) {
      final var key = nums1[i];
      map.putIfAbsent(key, new ArrayList<>());
      map.get(key).add(i);
    }

    return findMaxLength(nums1, nums2, 0, 0, map, 0);
  }

  private int findMaxLength(final int[] nums1,
                            final int[] nums2,
                            final int nums1Index,
                            final int nums2Index,
                            final Map<Integer, List<Integer>> map,
                            final int max) {
    if (nums1Index >= nums1.length || nums2Index >= nums2.length) {
      return max;
    } else {
      final var key2 = nums2[nums2Index];
      final var keys1 = map.getOrDefault(key2, List.of());

      var nextIndex1 = keys1.isEmpty() ? nums1Index + 1 : 0;
      var nextIndex2 = nums2Index + 1;
      var maxCount = 0;

      for (final var key1 : keys1) {
        maxCount = 0;

      }

      return 0;
    }
  }
}
