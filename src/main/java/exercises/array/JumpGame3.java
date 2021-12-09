package exercises.array;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class JumpGame3 {
  public Set<Integer> seen = new HashSet<>();

  public boolean canReach(final int[] arr, final int start) {
    if (start >= arr.length || start < 0 || seen.contains(start)) {
      return false;
    } else {
      seen.add(start);
      if (arr[start] == 0) return true;
      return canReach(arr, start + arr[start])
        || canReach(arr, start - arr[start]);
    }
  }
}
