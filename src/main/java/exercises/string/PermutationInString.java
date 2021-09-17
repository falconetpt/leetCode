package exercises.string;

import java.util.List;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Set;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class PermutationInString {
  public boolean checkInclusion(final String s1, final String s2) {
    final var sortedValue = s1.split("");
    Arrays.sort(sortedValue);
    final var elements = Arrays.stream(sortedValue)
      .collect(Collectors.toSet());

    return checkInclusion(s2, 0, new LinkedList<>(), elements, String.join("", sortedValue));
  }

  private boolean checkInclusion(final String s2,
                                 final int i,
                                 final LinkedList<String> strings,
                                 final Set<String> elements,
                                 final String sortedValue) {
    if (i >= s2.length()) {
      final var buildStr = strings.stream().sorted()
        .reduce("", String::concat);
      return buildStr.equals(sortedValue);
    } else if (strings.size() == sortedValue.length()) {
      final var buildStr = strings.stream().sorted()
        .reduce("", String::concat);
      if (buildStr.equals(sortedValue)) return true;
      strings.removeFirst();
      return checkInclusion(s2, i, strings, elements, sortedValue);
    } else {
      final var element = String.valueOf(s2.charAt(i));

      if (elements.contains(element)) {
        strings.addLast(element);
        return checkInclusion(s2, i + 1, strings, elements, sortedValue);
      } else {
        return checkInclusion(s2, i + 1, new LinkedList<>(), elements, sortedValue);
      }
    }
  }
}
