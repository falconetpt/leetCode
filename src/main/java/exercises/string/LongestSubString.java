package exercises.string;

public class LongestSubString {
  public String longestDupSubstring(final String s) {
    var result = "";

    for (int i = 0; i < s.length(); i++) {
      for (int j = i + result.length() + 1; j < s.length() + 1; j++) {
        final var element = s.substring(i, j);

        if (s.indexOf(element, i + 1) > 0) {
          result = element;
        }
      }
    }

    return result;
  }
}
