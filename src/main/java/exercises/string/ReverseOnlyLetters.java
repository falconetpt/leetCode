package exercises.string;

import java.util.HashSet;
import java.util.Set;

public class ReverseOnlyLetters {
  public String reverseOnlyLetters(final String s) {
    final var string = new StringBuilder(s.replaceAll("[^a-zA-Z]", ""))
      .reverse();

    for (int i = 0; i < s.length(); i++) {
      final var element = s.charAt(i);
      if (!Character.isLetter(element)) string.insert(i, element);
    }

    return string.toString();
  }
}
