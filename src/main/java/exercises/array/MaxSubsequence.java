package exercises.array;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaxSubsequence {
  public int maxLength(final List<String> arr) {
    return maxLength(arr, 0, new HashSet<>());
  }

  private int maxLength(final List<String> arr, final int i, final Set<Character> characters) {
    if (i >= arr.size()) {
      return characters.size();
    } else {
      final var element = arr.get(i);
      final var inititalSize = characters.size();
      Set<Character> newSet = new HashSet<>(characters);

      for (final var character : element.toCharArray()) {
        if (!newSet.contains(character)) {
          newSet.add(character);
        } else {
          return Math.max(maxLength(arr, i + 1, characters), maxLength(arr, i + 1, new HashSet<>()));
        }
      }

      newSet = element.length() + inititalSize == newSet.size()
        ? newSet
        : characters;

      return Math.max(
        maxLength(arr, i + 1, characters),
        Math.max(
          maxLength(arr, i + 1, newSet),
          maxLength(arr, i + 1, new HashSet<>())
        ));
    }
  }
}
