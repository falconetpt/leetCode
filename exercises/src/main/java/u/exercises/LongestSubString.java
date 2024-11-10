package u.exercises;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubString {
  public int lengthOfLongestSubstring(String s) {
    final var seen = new HashMap<Character, Integer>();
    var count = 0;
    var maxCount = 0;
    var left = 0;
    var right = 0;

    while (left < s.length() && right < s.length()) {
      final var element = s.charAt(right);
      seen.put(element, seen.getOrDefault(element, 0) + 1);
      final var elementCount = seen.get(element);

      if (elementCount > 1) {
        while (seen.get(element) > 1) {
          final var leftElement = s.charAt(left);
          seen.put(leftElement, seen.getOrDefault(leftElement, 0) - 1);
          left++;
        }
        count = right - left + 1;
      } else {
        count++;
      }
      maxCount = Math.max(count, maxCount);
      right++;
    }


    return maxCount;
  }
}
