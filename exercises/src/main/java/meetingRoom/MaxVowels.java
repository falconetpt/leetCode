package meetingRoom;

import java.util.Set;
import java.util.stream.IntStream;

public class MaxVowels {
  private final static Set<Character> VOWELS = Set.of(
      'a', 'e', 'i', 'o', 'u'
  );

  public int maxVowels(String s, int k) {
    var count = (int) IntStream.range(0, k)
        .filter(i -> VOWELS.contains(s.charAt(i)))
        .count();
    var maxCount = count;

    for (int i = k; i < s.length(); i++) {
      final var firstChar = s.charAt(i - k);
      final var currentChar = s.charAt(i);

      if (VOWELS.contains(currentChar)) count++;
      if (VOWELS.contains(firstChar)) count--;

      maxCount = Math.max(count, maxCount);
    }

    return maxCount;
  }
}
