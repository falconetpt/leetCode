package dp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CustomSorting {
  public String customSortString(String order, String s) {
    final var orderMap = new HashMap<Character, Integer>();
    IntStream.range(0, order.length())
        .forEach(i -> orderMap.put(order.charAt(i), i));

    final var strArr = s.split("");

    return Arrays.stream(strArr)
        .sorted(Comparator.comparing(a -> orderMap.getOrDefault(a.charAt(0), Integer.MAX_VALUE)))
        .collect(Collectors.joining());
  }
}
