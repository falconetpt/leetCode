package exercises.array;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SingleElement2 {
  public int singleNumber(int[] nums) {
    final var map = Arrays.stream(nums)
      .boxed()
      .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    return map.entrySet()
      .stream()
      .filter(e -> e.getValue() == 1)
      .findFirst()
      .map(Map.Entry::getKey)
      .orElse(0);

  }
}
