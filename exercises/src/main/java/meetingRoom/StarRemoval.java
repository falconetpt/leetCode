package meetingRoom;

import java.util.LinkedList;

public class StarRemoval {
  public String removeStars(String s) {
    final var linkedList = new LinkedList<Character>();

    for (int i = 0; i < s.length(); i++) {
      final var value = s.charAt(i);
      if (value == '*') {
        if (!linkedList.isEmpty()) linkedList.pollLast();
      } else {
        linkedList.addLast(value);
      }
    }

    return linkedList.stream()
        .map(String::valueOf)
        .reduce("", (a, b) -> a + b);
  }
}
