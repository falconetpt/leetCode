package dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IsInterleaving {
  public boolean isInterleave(String s1, String s2, String s3) {
    final var str = (s1 + s2).toCharArray();

    final var inputMap = createMap(str);
    final var resultMap = createMap(s3.toCharArray());

    return inputMap.equals(resultMap);
  }

  private Map<Character, Integer> createMap(char[] str) {
    final var result = new HashMap<Character, Integer>();

    for (final var value : str) {
      result.putIfAbsent(value, 0);
      result.put(value, result.get(value) + 1);
    }

    return result;
  }
}
