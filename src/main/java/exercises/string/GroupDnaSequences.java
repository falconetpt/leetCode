package exercises.string;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupDnaSequences {
  public List<String> findRepeatedDnaSequences(final String s) {
    final var map = new HashMap<String, Integer>();

    for (int i = 0; i < s.length() - 9; i++) {
      final var element = s.substring(i, i + 10);
      System.out.println(element);
      map.put(element, map.getOrDefault(element, 0) + 1);
    }

    return map.entrySet()
      .stream()
      .filter(e -> e.getValue() > 1)
      .map(Map.Entry::getKey)
      .collect(Collectors.toList());
  }
}
