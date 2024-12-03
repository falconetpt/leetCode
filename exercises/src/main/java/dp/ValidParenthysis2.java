package dp;

import java.util.LinkedList;
import java.util.Map;

public class ValidParenthysis2 {
  private static final Map<Character, Character> CLOSED_PARENTHYSIS = Map.of(
      '}', '{',
      ')', '(',
      ']', '['
  );

  public boolean isValid(String s) {
    final var linkedList = new LinkedList<Character>();

    for (int i = 0; i < s.length(); i++) {
      final var element = s.charAt(i);
      final var isClosingElement = CLOSED_PARENTHYSIS.containsKey(element);

      if (isClosingElement) {
        if (linkedList.isEmpty()) return false;
        if (!linkedList.pollLast().equals(CLOSED_PARENTHYSIS.get(element))) return false;
      } else {
        linkedList.add(element);
      }

    }

    return linkedList.isEmpty();
  }
}
