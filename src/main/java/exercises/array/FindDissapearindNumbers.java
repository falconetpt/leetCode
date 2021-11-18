package exercises.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindDissapearindNumbers {
  public List<Integer> findDisappearedNumbers(int[] nums) {
    final var set = IntStream.rangeClosed(1, nums.length)
      .boxed()
      .collect(Collectors.toSet());

    Arrays.stream(nums)
      .forEach(set::remove);

    return new ArrayList<>(set);
  }
}
