package exercises.number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Sum3Nums {
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    final var result = new HashSet<List<Integer>>();
    final var target = 0;

    for (int i = 0; i < nums.length - 2; i++) {
      final var remainder = target - nums[i];
      var start = i + 1;
      var end = nums.length - 1;

      while (end > start) {
        final var startValue = nums[start];
        final var endValue = nums[end];

        if (startValue + endValue == remainder) {
          final var array = new ArrayList<Integer>();
          array.add(nums[i]);
          array.add(startValue);
          array.add(endValue);
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

    return new ArrayList<>(result);
  }
}
