package exercises.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntersectTwoLists {
  public int[] intersect(int[] nums1, int[] nums2) {
    final var num1Frequency = Arrays.stream(nums1)
      .boxed()
      .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    final var num2Frequency = Arrays.stream(nums2)
      .boxed()
      .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    final var result = new ArrayList<Integer>();

    num1Frequency.entrySet()
      .stream()
      .filter(e -> num2Frequency.containsKey(e.getKey()))
      .forEach(e -> IntStream.range(0, (int) Math.min(e.getValue(), num2Frequency.get(e.getKey()))).forEach(x -> result.add(e.getKey())));


    return result.stream()
      .mapToInt(i -> i)
      .toArray();
  }
}
