package dp;

import jdk.jfr.Frequency;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopK {
  public int[] topKFrequent(int[] nums, int k) {
    final var map = Arrays.stream(nums)
        .boxed()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    final var value = map.entrySet()
        .stream()
        .sorted(Comparator.comparingLong(e -> -e.getValue()))
        .limit(k)
        .map(Map.Entry::getKey)
        .toList();

    final var result = new int[k];

    for (int i = 0; i < result.length; i++) {
      result[i] = value.get(i);
    }

    return result;
  }


}
