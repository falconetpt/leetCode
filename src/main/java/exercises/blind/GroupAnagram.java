package exercises.blind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagram {
  public List<List<String>> groupAnagrams(final String[] strs) {
    final var map = new HashMap<String, List<String>>();


    for (final var str : strs) {
      final var chars = str.split("");
      Arrays.sort(chars);
      final var sortedStr = String.join("", chars);

      map.putIfAbsent(sortedStr, new ArrayList<>());
      map.get(sortedStr).add(str);
    }

    return new ArrayList<>(map.values());
  }
}
