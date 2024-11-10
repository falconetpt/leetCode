package questions75;

public class MergeStrings {
  public String mergeAlternately(String word1, String word2) {
    final var sb = new StringBuilder();

    for (int i = 0; i < Math.max(word1.length(), word2.length()); i++) {
      final var char1 = (i >= word1.length())
          ? ""
          : word1.charAt(i) + "";
      final var char2 = (i >= word2.length())
          ? ""
          : word2.charAt(i) + "";

      sb.append(char1);
      sb.append(char2);

    }

    return sb.toString();
  }
}
