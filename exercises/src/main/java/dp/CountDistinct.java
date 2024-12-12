package dp;

import java.util.HashSet;
import java.util.LinkedList;

public class CountDistinct {
  public int countDistinct(int[] nums, int k, int p) {
    final var set = new HashSet<LinkedList<Integer>>();

    for (int i = 0; i < nums.length; i++) {
      var j = i;
      var remainder = k;
      final var element = new LinkedList<Integer>();

      while (remainder >= 0 && j < nums.length) {
        if (nums[j] % p == 0) remainder--;
        if(remainder >= 0) {
          element.add(nums[j]);
          set.add(new LinkedList<>(element));
          j++;
        }

      }
    }



    return set.size();
  }
}
