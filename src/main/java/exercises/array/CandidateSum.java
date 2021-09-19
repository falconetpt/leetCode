package exercises.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CandidateSum {
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    final var result = new HashSet<List<Integer>>();
    Arrays.sort(candidates);
    result.add(List.of());


    for (int i = 0; i < candidates.length; i++) {
      final var addSet = new HashSet<List<Integer>>();
      for (final var item : result) {
        final var copy = new ArrayList<>(item);
        copy.add(candidates[i]);
        addSet.add(copy);
      }
      result.addAll(addSet);
    }


    return result.stream()
      .filter(x -> x.stream().reduce(0, Integer::sum) == target)
      .collect(Collectors.toList());
  }
}
