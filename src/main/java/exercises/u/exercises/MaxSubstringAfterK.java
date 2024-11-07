package exercises.u.exercises;

import java.util.HashMap;

public class MaxSubstringAfterK {
  public int characterReplacement(String s, int k) {
    if (s.length() == 0) return 0;

    int max = 0;

    for (int i = 0; i < s.length(); i++) {
      max = Math.max(max, calculateMax(s,i, k));
    }

    return max;
  }

  private int calculateMax(String s, int startIndex, int k) {
    final char c = s.charAt(startIndex);
    final var charMap = new HashMap<Character, Integer>();
    charMap.putIfAbsent(c, 1);
    var count = 1;

    var maxChar = c;

    for (int i = startIndex + 1; i < s.length(); i++) {
      final var element = s.charAt(i);
      charMap.put(element, charMap.getOrDefault(element, 0) + 1);

      if (charMap.get(element) > charMap.get(maxChar)) maxChar = element;

      if (charMap.get(maxChar) + k > (i - startIndex)) return count -1;

      count++;
    }

    return count;
  }
}
