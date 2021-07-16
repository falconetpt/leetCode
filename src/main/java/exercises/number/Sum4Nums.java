package exercises.number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sum4Nums {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    final var result = new HashSet<List<Integer>>();

    for (int i = 0; i < nums.length; i++) {
      final int newTarget = target - nums[i];
      threeSum(nums, newTarget, i + 1, result, nums[i]);
    }

    return new ArrayList<>(result);
  }

  public void threeSum(int[] nums, int target, int start, final Set<List<Integer>> result, int base) {
    for (int i = 0; i < nums.length - 2; i++) {
      final var remainder = target - nums[i];
      var end = nums.length - 1;

      while (end > start) {
        final var startValue = nums[start];
        final var endValue = nums[end];

        if (startValue + endValue == remainder) {
          final var array = new ArrayList<Integer>();
          array.add(nums[i]);
          array.add(startValue);
          array.add(endValue);
          array.add(base);
          result.add(array);
          start++;
          end--;
        } else {
          if(startValue + endValue < remainder){
            start++;
          }
          else{
            end--;
          }
        }
      }

    }
  }
}
