package exercises.number;

import java.util.HashMap;
import java.util.Map;

public class MaxScoreMultiplication {

  public static final String KEY_FORMAT = "%s_%s";

  public int maximumScore(final int[] nums,
                          final int[] multipliers) {
    return maximumScore(nums, multipliers, 0, nums.length - 1, 0, new HashMap<>());
  }

  private int maximumScore(int[] nums,
                           int[] multipliers,
                           int numsLeftIndex,
                           int numsRightIndex,
                           int mutipliersIndex,
                           Map<String, Integer> map) {
    final var key = String.format(KEY_FORMAT, numsLeftIndex, numsRightIndex);
    if (mutipliersIndex >= multipliers.length) {
      return 0;
    } else if (map.containsKey(key)) {
      return map.get(key);
    } else {
      final var leftValue = nums[numsLeftIndex] * multipliers[mutipliersIndex]
        + maximumScore(nums, multipliers, numsLeftIndex + 1,
        numsRightIndex, mutipliersIndex + 1, map);
      final var rightValue = nums[numsRightIndex] * multipliers[mutipliersIndex]
        + maximumScore(nums, multipliers, numsLeftIndex,
        numsRightIndex - 1, mutipliersIndex + 1, map);
      final var maxValue = Math.max(leftValue, rightValue);
      map.put(key, maxValue);
      return maxValue;
    }
  }
}
