package exercises.blind;

import java.util.HashSet;
import java.util.LinkedList;

public class LongestSubstringWithoutRepeatingChars {
  public int lengthOfLongestSubstring(final String s) {
    final var set = new HashSet<Character>();
    final var linkedList = new LinkedList<Character>();
    var max = 0;

    for (int i = 0; i < s.length(); i++) {
      final var element = s.charAt(i);
      if (set.contains(element)) {
        max = Math.max(max, set.size());

        while (!linkedList.isEmpty() && linkedList.peekFirst() != element) {
            set.remove(linkedList.pollFirst());
        }

        linkedList.pollFirst();
      }
      linkedList.add(element);
      set.add(element);
    }

    return Math.max(max, set.size());
  }
}
