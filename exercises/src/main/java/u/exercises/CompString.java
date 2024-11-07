package u.exercises;

public class CompString {

  private static final int MAX_SPLIT = 9;

  public String compressedString(String word) {

    if (word.isEmpty()) return "";

    final var sb = new StringBuilder();
    final var newWord = word + " ";
    var lastChar = word.charAt(0);
    var count = 1;

    for (int i = 1; i < newWord.length(); i++) {
      final var element = newWord.charAt(i);

      if (lastChar == element) {
        if (count == MAX_SPLIT) {
          sb.append(count);
          sb.append(lastChar);
          count = 1;
        } else {
          count += 1;
        }
      } else {
        sb.append(count);
        sb.append(lastChar);
        lastChar = element;
        count = 1;
      }
    }

    return sb.toString();
  }
}
