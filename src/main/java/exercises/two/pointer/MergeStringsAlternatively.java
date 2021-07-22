package exercises.two.pointer;

public class MergeStringsAlternatively {
  public String mergeAlternately(final String word1, final String word2) {
    final var result = new StringBuffer();

    for (int i = 0, n = Math.max(word1.length(), word2.length()); i < n; i++) {
      if (i < word1.length()) result.append(word1.charAt(i));
      if (i < word2.length()) result.append(word2.charAt(i));
    }

    return result.toString();
  }
}
