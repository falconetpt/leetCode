package exercises.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LargestDivisibleSubset {
  public List<Integer> largestDivisibleSubset(final int[] nums) {
    Arrays.sort(nums);
    final var cache = new ArrayList<LinkedList<Integer>>();
    cache.add(new LinkedList<>());
    List<Integer> result = List.of();


    for (final var num : nums) {
      final var newElements = new ArrayList<LinkedList<Integer>>();

      for (final var list : cache) {
        if (list.isEmpty() || num % list.peekLast() != 0) {
          final var newList = new LinkedList<Integer>() {{ addLast(num); }};
          newElements.add(newList);
          if (result.size() <= newList.size()) result = newList;
        } else {
          newElements.add(new LinkedList<>(list));
          list.addLast(num);
        }

        if (result.size() <= list.size()) result = list;
      }

      cache.addAll(newElements);
    }


    return result;
  }
}
