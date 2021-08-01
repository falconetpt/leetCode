package exercises.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Intersect {
  public int[] intersect(final int[] nums1, final int[] nums2) {
    final var nums1Frequency = Arrays.stream(nums1)
      .boxed()
      .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    final var nums2Frequency = Arrays.stream(nums2)
      .boxed()
      .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    return nums1Frequency.keySet()
      .stream()
      .filter(nums2Frequency::containsKey)
      .flatMap(k -> IntStream.range(0, (int) Math.min(nums1Frequency.get(k), nums2Frequency.get(k))).map(x -> k).boxed())
      .mapToInt(i -> i)
      .toArray();
  }
}
