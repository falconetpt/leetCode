package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GroupAnagram {
  public List<List<String>> groupAnagrams(String[] strs) {
    final var frequencyMap = new HashMap<Map<Character, Long>, List<String>>();


    for (final var str : strs) {
      final var strFrequency = IntStream.range(0, str.length())
          .boxed()
          .map(str::charAt)
          .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
      frequencyMap.putIfAbsent(strFrequency, new ArrayList<>());
      frequencyMap.get(strFrequency).add(str);
    }


    return frequencyMap.values().stream().toList();
  }
}
