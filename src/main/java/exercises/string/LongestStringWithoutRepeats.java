package exercises.string;

import java.util.HashSet;
import java.util.LinkedList;

public class LongestStringWithoutRepeats {
  public int lengthOfLongestSubstring(final String s) {
    final var seen = new HashSet<Character>();
    final var link = new LinkedList<Character>();
    var count = 0;

    for (final var c : s.toCharArray()) {
      if (seen.contains(c)) {
        while (link.size() > 0 && link.peekFirst() != c) {
          seen.remove(link.pollFirst());
        }
        link.pollFirst();
      } else {
        seen.add(c);
      }

      link.addLast(c);

      count = Math.max(count, link.size());
    }

    return count;
  }
}
