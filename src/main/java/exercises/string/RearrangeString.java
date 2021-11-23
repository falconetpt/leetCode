package exercises.string;

import java.util.stream.IntStream;

public class RearrangeString {
  public String reorderSpaces(final String text) {
    final var words = text.trim().split("\\s+");

    final var spaces = IntStream.range(0, text.length())
      .map(text::charAt)
      .filter(c -> c == ' ')
      .count();
    final var spacesBetweenWords = spaces / Math.max((words.length - 1), 1);
    final var spacesBetweenWordsLeft = spaces % Math.max((words.length - 1), 1);
    final var spaceString = IntStream.range(0, (int) spacesBetweenWords)
      .boxed()
      .map(i -> " ")
      .reduce("", String::concat);

    if (words.length == 1) return words[0] + spaceString;

    return String.join(spaceString, words) + IntStream.range(0, (int) spacesBetweenWordsLeft)
      .boxed()
      .map(i -> " ")
      .reduce("", String::concat);
  }
}
