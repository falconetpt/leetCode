package dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class AddSpacesToString {
  public String addSpaces(String s, int[] spaces) {
    final var sb = new StringBuilder();
    final var queue = Arrays.stream(spaces).boxed()
        .collect(Collectors.toCollection(LinkedList::new));

    for (int i = 0; i < s.length(); i++) {
      final var currentElement = s.charAt(i);
      if (!queue.isEmpty() && queue.peekFirst() == i) {
        sb.append(" ");
        queue.pollFirst();
      }
      sb.append(currentElement);
    }

    return sb.toString();
  }
}
