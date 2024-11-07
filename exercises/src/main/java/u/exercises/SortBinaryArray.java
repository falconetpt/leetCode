package u.exercises;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;

public class SortBinaryArray {
  public boolean canSortArray(int[] nums) {
    if (isSorted(nums)) return true;
    sortArray(nums);

    return isSorted(nums);
  }

  private void sortArray(int[] nums) {
    final var priorityQueue = new PriorityQueue<Integer>(Comparator.comparing(a -> a));
    var leftPointer = 0;
    var rightPointer = 1;
    priorityQueue.add(nums[leftPointer]);

    while (leftPointer < nums.length && rightPointer < nums.length){
      final var firstElement = nums[leftPointer];
      final var currentElement = nums[rightPointer];

      if (countBits(firstElement) == countBits(currentElement)) {
        rightPointer++;
      } else {
        fillArray(priorityQueue, leftPointer, rightPointer, nums);
        leftPointer = rightPointer;

        rightPointer++;
      }
      priorityQueue.add(currentElement);
    }

    fillArray(priorityQueue, leftPointer, rightPointer, nums);
  }

  private void fillArray(PriorityQueue<Integer> priorityQueue, int leftPointer, int rightPointer, int[] nums) {
    //System.out.println(priorityQueue);
    //System.out.println(leftPointer + ":" + rightPointer);
    for (int i = leftPointer; i < rightPointer; i++) {
      nums[i] = priorityQueue.poll();
    }
  }

  private boolean isSorted(int[] nums) {
    for (int i = 1; i < nums.length; i++) {
      if (nums[i-1] > nums[i]) return false;
    }

    return true;
  }

  private int countBits(int n) {
    if (n == 0) {
      return 0;
    } else {
      final var remainder = n % 2;
      final var countBit = remainder == 1
          ? 1
          : 0;

      return countBit + countBits(n/2);
    }
  }
}
