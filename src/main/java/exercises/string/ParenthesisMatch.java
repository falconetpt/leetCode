package exercises.string;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ParenthesisMatch {
  private final Map<Character, Character> MATCH = Map.of(
    '}', '{',
    ')', '(',
    ']', '['
  );

  public boolean isValid(final String s) {
    final var queue = new LinkedList<Character>();


    for (final var c : s.toCharArray()) {
      if (MATCH.containsValue(c)) {
        queue.addLast(c);

      } else {
        final var element = queue.isEmpty()
          ? ' '
          : queue.pollLast();

        if (MATCH.getOrDefault(c, ' ') != element) {
          return false;
        }
      }
    }

    return queue.isEmpty();
  }
}
