package exercises.string;

import java.util.LinkedList;

public class ReverseStringWhite {
  public String reverseWords(final String s) {
    final var result = new StringBuilder();
    var str = new StringBuilder();

    for (int i = 0; i < s.length(); i++) {
      final var element = s.charAt(i);

      if (element == ' ') {
        if (str.length() > 0) result.insert(0, str + " ");
        str = new StringBuilder();
      } else {
        str.append(element);
      }
    }

    if (str.length() > 0) result.insert(0, str + " ");

    return result
      .toString()
      .trim();
  }
}
