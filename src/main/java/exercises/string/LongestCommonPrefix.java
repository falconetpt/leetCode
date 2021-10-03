package exercises.string;

import java.util.stream.IntStream;

public class LongestCommonPrefix {
  public String longestCommonPrefix(final String[] strs) {
    var str = strs[0];

    for (int i = 1; i < strs.length; i++) {
      final var element = strs[i];
      final var strFinal = str;
      str = IntStream.range(0, Math.min(str.length(), element.length()))
        .boxed()
        .filter(e -> element.charAt(e) != strFinal.charAt(e))
        .findFirst()
        .map(e -> strFinal.substring(0, e))
        .orElse(strFinal.substring(0, Math.min(str.length(), element.length())));
    }

    return str;
  }
}
