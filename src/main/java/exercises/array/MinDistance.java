package exercises.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinDistance {
  public List<List<Integer>> minimumAbsDifference(final int[] arr) {
    Arrays.sort(arr);
    var min = Integer.MAX_VALUE;
    var result = new ArrayList<List<Integer>>();

    for (int i = 1; i < arr.length; i++) {
      min = Math.min(min, arr[i] - arr[i - 1]);
    }

    for (int i = 1; i < arr.length; i++) {
      if (arr[i] - arr[i - 1] == min) {
        result.add(List.of(arr[i - 1], arr[i]));
      }
    }

    return result;
  }
}
