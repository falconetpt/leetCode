package exercises.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class ParityArray {
  public int[] sortArrayByParity(final int[] nums) {
    return Arrays.stream(nums)
      .boxed()
      .sorted(Comparator.comparing(x -> x % 2))
      .mapToInt(i -> i)
      .toArray();
  }
}
