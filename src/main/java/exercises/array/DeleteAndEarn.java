package exercises.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DeleteAndEarn {
  public int deleteAndEarn(final int[] nums) {
    final var map = Arrays.stream(nums)
      .sorted()
      .boxed()
      .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    return map.entrySet()
      .stream()
      .map(e -> getElements(map, e.getKey(), new HashSet<>()))
      .mapToInt(i -> i)
      .max()
      .orElse(0);
  }

  private int getElements(
    final Map<Integer, Long> map,
    final Integer key,
    final HashSet<Integer> integers) {
    if (integers.contains(key)) return 0;
    final var value = map.getOrDefault(key, 0L);

    integers.add(key);
    integers.add(key + 1);
    integers.add(key -1);
    final var localTotal = value * key;
    final var plus = getElements(map,key + 1, integers);
    final var minus = getElements(map,key + 1 , integers);

    return (int) localTotal + plus + minus;
  }
}
