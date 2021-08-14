package exercises.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CanReorderDoubled {
  public boolean canReorderDoubled(int[] arr) {
    Map<Integer, Long> count = Arrays.stream(arr)
      .boxed()
      .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    Integer[] B = new Integer[arr.length];
    for (int i = 0; i < arr.length; ++i)
      B[i] = arr[i];

    Arrays.sort(B, Comparator.comparing(Math::abs));

    for (int x: B) {
      if (count.get(x) == 0) continue;
      if (count.getOrDefault(2*x, 0L) <= 0) return false;
      count.put(x, count.get(x) - 1);
      count.put(2*x, count.get(2*x) - 1);
    }

    return true;

  }
}
