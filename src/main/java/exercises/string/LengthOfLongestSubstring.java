package exercises.string;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
  public int lengthOfLongestSubstring(final String s) {
    return lengthOfLongestSubstring(s, 0, 0, 0, new HashSet<>());
  }

  private int lengthOfLongestSubstring(final String s,
                                       final int start,
                                       final int end,
                                       final int max,
                                       final Set<Character> characters) {
    if (end >= s.length()) {
      return Math.max(max, end - start);
    } else {
      final var element = s.charAt(end);

      if (characters.contains(element)) {
        characters.remove(s.charAt(start));
        return lengthOfLongestSubstring(s, start + 1, end, Math.max(max, end - start), characters);
      } else {
        characters.add(element);
        return lengthOfLongestSubstring(s, start, end + 1, Math.max(max, end - start), characters);
      }
    }
  }
}
