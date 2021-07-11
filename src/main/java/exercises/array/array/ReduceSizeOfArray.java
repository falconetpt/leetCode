package exercises.array.array;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReduceSizeOfArray {
  public int minSetSize(int[] arr) {
    return Arrays.stream(arr)
      .boxed()
      .collect(Collectors.toSet())
      .size();
  }
}
