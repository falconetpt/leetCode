package dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SubsetsFb {
  public List<List<Integer>> subsets(int[] nums) {
    final var set = new HashSet<List<Integer>>();
    set.add(List.of());

    for (final var num : nums) {
      final var expandedSet = set.stream()
          .map(l -> {
            final var list = new ArrayList<>(l);
            list.add(num);
            return list;
          }).toList();

      set.addAll(expandedSet);
    }

    return new ArrayList<>(set);
  }
}
