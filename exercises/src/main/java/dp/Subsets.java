package dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subsets {
  public List<List<Integer>> subsets(int[] nums) {
    final Set<List<Integer>> result = new HashSet<>();
    result.add(List.of());

    for(final var num : nums) {
      final var resultStream = result.stream().toList();

      resultStream.forEach(l -> {
        final var newList = new ArrayList<>(l);
        newList.add(num);
        result.add(newList);
      });
    }

    return result.stream().toList();

  }
}
