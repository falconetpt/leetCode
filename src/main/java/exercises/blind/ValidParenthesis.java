package exercises.blind;

import java.util.LinkedList;
import java.util.Map;

public class ValidParenthesis {
  private static final Map<Character, Character> VALID_PARENTHESIS = Map.of(
    ')', '(',
    '}', '{',
    ']', '['
  );

  public boolean isValid(final String s) {
    final var stack = new LinkedList<Character>();

    for (int i = 0; i < s.length(); i++) {
      final var element = s.charAt(i);

      if (VALID_PARENTHESIS.containsKey(element)) {
        if (stack.isEmpty()) return false;
        if (stack.pollLast() != VALID_PARENTHESIS.get(element)) return false;
      } else {
        stack.addLast(element);
      }
    }

    return stack.isEmpty();
  }
}
