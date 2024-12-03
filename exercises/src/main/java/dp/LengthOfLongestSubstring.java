package dp;

import java.util.HashMap;

public class LengthOfLongestSubstring {
  public int lengthOfLongestSubstring(String s) {
    final var seenMap = new HashMap<Character, Integer>();
    var left = 0;
    var right = 0;

    var maxLength = 0;

    while (right < s.length()) {
      final var element = s.charAt(right);
      seenMap.put(element, seenMap.getOrDefault(element, 0) + 1);

      if (seenMap.getOrDefault(element, 0) > 1) {
        left = calculateNewLeft(left, right, element, s, seenMap) + 1;
      }


      right++;
      maxLength = Math.max(maxLength, right - left);
    }


    return maxLength;
  }

  private int calculateNewLeft(int left, int right, char target,
                               String s, HashMap<Character, Integer> seenMap) {
    for (int i = left; i < right; i++) {
      final var element = s.charAt(i);
      seenMap.put(element, seenMap.get(element) - 1);

      if (element == target) return i;
    }

    return  -1;
  }
}
