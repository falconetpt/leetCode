package exercises.array;

import java.util.LinkedList;
import java.util.List;

public class FindClosestElement {
  public List<Integer> findClosestElements(int[] arr, int k, int x) {
    final var index = findIndex(arr, x);
    final var result = new LinkedList<Integer>();
    result.add(arr[index]);
    var nextIndex = index + 1;
    var prevIndex = index - 1;

    while (result.size() != k) {
      if (prevIndex >= 0) {
        result.addFirst(arr[prevIndex]);
        prevIndex--;
      }

      if (nextIndex < arr.length && result.size() != k) {
        result.addLast(arr[nextIndex]);
        nextIndex++;
      }
    }

    return result;
  }

  protected int findIndex(final int[] arr, final int target) {
    var minDistance = Integer.MAX_VALUE;
    var index = 0;

    for (int i = 0; i < arr.length; i++) {
      final var localDistance = Math.abs(target - arr[i]);
      if (localDistance < minDistance) {
        minDistance = localDistance;
        index = i;
      }
    }


    return index;
  }
}
