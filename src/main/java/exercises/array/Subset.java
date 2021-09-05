package exercises.array;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Subset {
  public List<List<Integer>> subsets(final int[] nums) {
    final var result = new ArrayList<List<Integer>>();
    result.add(List.of());

    return subsets(nums, 0, result);
  }

  private List<List<Integer>> subsets(final int[] nums, final int i, final List<List<Integer>> result) {
    if (i >= nums.length) {
      return result;
    } else {
      final var element = nums[i];

      final var newSet = result.stream()
        .map(ArrayList::new)
        .peek(l -> l.add(element))
        .collect(Collectors.toList());

      result.addAll(newSet);

      return subsets(nums, i + 1, result);
    }
  }
}
