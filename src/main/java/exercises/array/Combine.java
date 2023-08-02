package exercises.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Combine {
  public List<List<Integer>> combine(int n, int k) {
    final var set = new HashSet<Set<Integer>>();

    generateCombos(n, k, set);

    return set.stream()
        .map(ArrayList::new)
        .collect(Collectors.toList());
  }

  private static void generateCombos(int n, int k, Set<Set<Integer>> set) {
    for (int i = 1; i <= n; i++) {
      final var localSet = new HashSet<Integer>();
      localSet.add(i);
      set.addAll(generateCombos(i + 1, n, k -1, localSet, new LinkedList<>()));
    }
  }

  private static List<Set<Integer>> generateCombos(int i, int n, int k,
                                                   Set<Integer> localSet, LinkedList<Set<Integer>> sets) {
    if (k == 0) {
      sets.add(localSet);
      return sets;
    } else {
      for (int j = i; j <= n; j++) {
        final var replicatedSet = new HashSet<>(localSet);
        replicatedSet.add(j);

        generateCombos(j + 1, n, k -1, replicatedSet, sets);
      }
    }

    return sets;
  }
}
