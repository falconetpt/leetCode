package exercises.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public class SmallerElements {
  public List<Integer> countSmaller(final int[] nums) {
    final var map = new TreeMap<Integer, AtomicInteger>();
    Arrays.stream(nums)
      .peek(i -> map.putIfAbsent(i, new AtomicInteger(0)))
      .forEach(i -> map.get(i).addAndGet(1));

    final var result = new ArrayList<Integer>();

    for (final var num : nums) {
      map.get(num).addAndGet(-1);
      final var value = map.subMap(Integer.MIN_VALUE, num)
        .values()
        .stream()
        .map(AtomicInteger::get)
        .reduce(0, Integer::sum);
      result.add(value);
    }

    return result;
  }
}
