package exercises.array;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class MaxChunks {
  public int maxChunksToSorted(final int[] arr) {
    final var priorityList = Arrays.stream(arr)
      .boxed()
      .collect(Collectors.toCollection(PriorityQueue::new));

    return maxChunksToSorted(arr, 0, priorityList, 0, Integer.MIN_VALUE);
  }

  private int maxChunksToSorted(final int[] arr,
                                final int i,
                                final PriorityQueue<Integer> priorityList,
                                final int result,
                                final int prevValue) {
    if (i >= arr.length) {
      return result;
    } else {
      final var element = priorityList.peek();

      if (prevValue < arr[i]) {
        return maxChunksToSorted(arr, i + 1, priorityList, result + 1, arr[i]);
      } else {
        if (element == arr[i]) {
          priorityList.poll();
          return maxChunksToSorted(arr, i + 1, priorityList, 1, arr[i]);
        }

        return maxChunksToSorted(arr, i + 1, priorityList, result, arr[i]);
      }
    }
  }


}
