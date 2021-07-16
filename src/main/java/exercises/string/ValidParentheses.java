package exercises.string;

import java.util.LinkedList;
import java.util.Map;

public class ValidParentheses {
  private static final Map<Character, Character> matching = Map.of(
    '}', '{',
    ')', '(',
    ']', '['
  );

  public boolean isValid(final String s) {
    final var queue = new LinkedList<Character>();

    for (final var c: s.toCharArray()) {
      if (!matching.containsKey(c)) {
        queue.addLast(c);
      } else {
        if (queue.isEmpty() || queue.pollLast() != matching.get(c)) return false;
      }
    }

    return queue.isEmpty();
  }
}
