package dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindSubstring {
  public List<Integer> findSubstring(String s, String[] words) {
    final var permutations = generatePermutations(words);

    final var result = new ArrayList<Integer>();

    for (final var permutation : permutations) {
      var nextIndex = 0;
      while (s.indexOf(permutation, nextIndex) != -1) {
        nextIndex = s.indexOf(permutation, nextIndex);
        result.add(nextIndex);
        nextIndex++;
      }
    }

    return result;
  }

  private Set<String> generatePermutations(final String[] words) {
    var result = new HashSet<LinkedList<String>>();
    result.add(new LinkedList<>(List.of(words[0])));

    for (int i = 1; i < words.length; i++) {
      final var element = words[i];
      final var newResult = new HashSet<LinkedList<String>>();
      for(final var locs : result) {
        for (int j = 0; j <= locs.size(); j++) {
          final var newVal = new LinkedList<>(locs);
          newVal.add(j, element);
          newResult.add(newVal);

        }

      }

      result = newResult;
    }

    return result.stream()
        .map(l -> String.join("", l))
        .collect(Collectors.toSet());
  }
}
