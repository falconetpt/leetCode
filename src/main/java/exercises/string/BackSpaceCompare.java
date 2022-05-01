package exercises.string;

import java.util.LinkedList;

public class BackSpaceCompare {
  private final static Character BACKSPACE = '#';

  public boolean backspaceCompare(final String s, final String t) {
    return backspaceConstruct(s).equals(backspaceConstruct(t));
  }

  private String backspaceConstruct(final String s) {
    final var queue = new LinkedList<Character>();

    for (final var c : s.toCharArray()) {
      if (c == BACKSPACE ) {
        if(!queue.isEmpty()) queue.pollLast();
      } else {
        queue.add(c);
      }
    }

    return queue.stream()
      .map(String::valueOf)
      .reduce((a, b) -> a + b)
      .orElse("");
  }
}
