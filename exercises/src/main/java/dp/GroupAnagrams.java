package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GroupAnagrams {
  public List<List<String>> groupAnagrams(String[] strs) {
    final var result = new HashMap<Map<Character, Long>, List<String>>();


    for (final var str : strs) {
      final var key = IntStream.range(0, str.length())
          .boxed()
          .map(str::charAt)
          .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

      result.putIfAbsent(key, new ArrayList<>());

      result.get(key).add(str);
    }

    return result.values().stream()
        .toList();
  }
}
