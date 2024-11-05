package exercises.u.exercises;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LongestSubarrayLimit {
  public int longestSubarray(int[] nums, int limit) {
    if ( nums.length == 1) return 1;
    int leftPointer = 0;
    int rightPointer = 1;

    final var priorityQueueMin = new PriorityQueue<Integer>(Comparator.comparing(i -> i));
    final var priorityQueueMax = new PriorityQueue<Integer>(Comparator.comparing(i -> -i));

    int element = nums[leftPointer];
    priorityQueueMin.add(element);
    priorityQueueMax.add(element);

    int maxLength = 0;


    while (rightPointer < nums.length) {
      final var currentElement = nums[rightPointer];
      final var firstElement = nums[leftPointer];

      priorityQueueMin.add(currentElement);
      priorityQueueMax.add(currentElement);

      final var delta = Math.abs(priorityQueueMax.peek() - priorityQueueMin.peek());

      if (delta > limit) {
        leftPointer++;
        priorityQueueMin.remove(firstElement);
        priorityQueueMax.remove(firstElement);
      } else {
        rightPointer++;
      }

      maxLength = Math.max(maxLength, rightPointer - leftPointer + 1);


    }

    return maxLength;
  }
}
