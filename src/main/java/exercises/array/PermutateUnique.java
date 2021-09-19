package exercises.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class PermutateUnique {
  public List<List<Integer>> permuteUnique(final int[] nums) {
    final var base = Arrays.stream(nums)
      .boxed()
      .collect(Collectors.toList());

    final var result = new HashSet<List<Integer>>();
    result.add(List.of(nums[0]));

    for (int i = 1; i < nums.length; i++) {
      final var newSet = new HashSet<List<Integer>>();

      for (final var list : result) {
        for (int j = 0; j <= list.size(); j++) {
          final var copyList = new ArrayList<>(list);
          copyList.add(j, nums[i]);
          newSet.add(copyList);
        }
      }

      result.clear();
      result.addAll(newSet);
    }

    return result.stream()
      .filter(l -> l.size() == nums.length)
      .collect(Collectors.toList());
  }
}
