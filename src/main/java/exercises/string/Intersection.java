package exercises.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Intersection {
  public List<Integer> intersection(int[][] nums) {
    final var test = Arrays.stream(nums)
      .map(s -> Arrays.stream(s).boxed().collect(Collectors.toSet()))
      .collect(Collectors.toSet());

    final var newSet = test.stream().findFirst()
      .orElse(new HashSet<>());

    for (var set: test) {
      newSet.retainAll(set);
    }

    return newSet.stream()
      .sorted()
      .collect(Collectors.toList());
  }
}
