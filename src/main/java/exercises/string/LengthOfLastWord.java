package exercises.string;

public class LengthOfLastWord {
  public int lengthOfLastWord(final String s) {
    final var words = s.split("\\s+");

    return words.length > 0
      ? words[words.length - 1].length()
      : 0;
  }
}
