package exercises.string;

import java.util.HashSet;
import java.util.stream.IntStream;

public class BeautySum {
  public int beautySum(final String s) {
    final var frequency = new int[26];
    IntStream.range(0, s.length())
      .mapToObj(s::charAt)
      .forEach(i -> frequency[i - 'a']++);

    return beautySum(s, 0, s.length(), frequency, new HashSet<String>());
  }

  private int beautySum(final String s,
                        final int start,
                        final int end,
                        final int[] frequency,
                        final HashSet<String> strings) {
    final var key = start + "-" + end;
    if (strings.contains(key)) return 0;
    if (start >= end) {
      return 0;
    } else {
      strings.add(key);
      var max = 0;
      var min = s.length();

      for (int i = start; i < end; i++) {
        final var element = s.charAt(i) - 'a';
        max = Math.max(frequency[element], max);
        min = Math.min(frequency[element], min);
      }

      frequency[s.charAt(start) - 'a']--;
      final var left = beautySum(s, start + 1, end, frequency, strings);
      frequency[s.charAt(start) - 'a']++;

      frequency[s.charAt(end -1) - 'a']--;
      final var right = beautySum(s, start, end - 1, frequency, strings);
      frequency[s.charAt(end -1) - 'a']++;

      return max - min
        + left
        + right;
    }
  }
}
