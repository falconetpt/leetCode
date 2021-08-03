package exercises.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

public class SubsetDupes {
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    final var result = new HashSet<List<Integer>>();
    result.add(List.of());

    for (int i = 0; i < nums.length; i++) {
      final var value = nums[i];

      final var newList = result.stream()
        .map(ArrayList::new)
        .peek(list -> list.add(value))
        .peek(list -> list.sort(Integer::compareTo))
        .collect(Collectors.toList());

      result.addAll(newList);
    }

    return new ArrayList<>(result);
  }
}
