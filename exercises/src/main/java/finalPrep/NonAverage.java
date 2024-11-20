package finalPrep;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class NonAverage {
  public int[] rearrangeArray(int[] nums) {
    final var queue = Arrays.stream(nums)
        .boxed()
        .sorted()
        .collect(Collectors.toCollection(LinkedList::new));

    final var result = new int[nums.length];

    for (int i = 0; i < nums.length; i++) {
      final var element = i % 2 == 0
          ? queue.pollLast()
          : queue.pollFirst();

      result[i] = element;

    }

    return result;
  }

}
