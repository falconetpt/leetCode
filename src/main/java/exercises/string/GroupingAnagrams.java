package exercises.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupingAnagrams {
  public List<List<String>> groupAnagrams(final String[] strs) {
    final var result = new HashMap<String, List<String>>();
    Arrays.stream(strs).forEach(s -> fillMap(s, result));

    return new ArrayList<>(result.values());
  }

  private void fillMap(final String s, final HashMap<String, List<String>> result) {
    final var charArr = s.split("");
    Arrays.sort(charArr);
    final var str = String.join("", charArr);
    result.putIfAbsent(str, new ArrayList<>());
    result.get(str).add(s);
  }
}
