package exercises.array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IncreasingTriplets {
    public boolean increasingTriplet(int[] nums) {
        List<Integer> max = Arrays.stream(nums).boxed()
                .sorted((a, b) -> - a.compareTo(b))
                .limit(2)
                .collect(Collectors.toList());

        if (max.isEmpty()) {
            return false;
        } else {
            return increasingTriplet(nums, 0, Integer.MIN_VALUE, 0, max);
        }
    }

    private boolean increasingTriplet(int[] nums, int index, int minValue, int count, List<Integer> max) {
        if (count == 3) {
            return true;
        } else if(index >= nums.length) {
            return false;
        } else if (nums[index] >= minValue) {
            return max.stream().anyMatch(n -> nums[index] <= n)
                    && increasingTriplet(nums, index + 1, nums[index], count + 1, max);
        } else {
            return increasingTriplet(nums, index + 1, minValue, count, max);
        }
    }
}
