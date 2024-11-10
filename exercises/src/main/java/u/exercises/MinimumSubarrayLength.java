package u.exercises;

import java.util.LinkedList;

public class MinimumSubarrayLength {
  public int minimumSubarrayLength(int[] nums, int k) {
    var elements = new LinkedList<Integer>();
    var min = Integer.MAX_VALUE;
    var sum = 0;

    for (int i = 0; i < nums.length; i++) {
      final var element = nums[i];
      elements.add(element);
      final var newSum = sum | element;
      //System.out.println(newSum + ":" + elements);

      if (newSum >= k) {
        min = Math.min(min, elements.size());
        sum = expand(newSum, elements, k);
        //System.out.println(newSum + ":" + elements);
        min = Math.min(min, elements.size());

        if (min == 1) return 1;
      } else {
        sum = newSum;
      }
    }

    return min == Integer.MAX_VALUE
        ? -1
        : min;

  }

  private int expand(int newSum, LinkedList<Integer> elements, int k) {
    var sum = newSum;

    while (elements.size() > 1) {
      final var element = elements.pollFirst();
      final var localSum = elements.stream().reduce(0, (a,b) -> a | b);
      if (localSum >= k) {
        sum = localSum;
      } else {
        elements.addFirst(element);
        return sum;
      }
    }

    return sum;

  }
}
