package exercises.array.array;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class CountSmaller {
  public List<Integer> countSmaller(int[] nums) {
    final var treeMap = new TreeMap<Integer, Integer>();
    final var result = new LinkedList<Integer>();

    for (int i = nums.length - 1; i >= 0; i--) {
      final var element = nums[i];
      final var valuesLessThanElement = treeMap.headMap(element)
        .values()
        .stream()
        .reduce(0, Integer::sum);

      result.addFirst(valuesLessThanElement);
      treeMap.putIfAbsent(element, 0);
      treeMap.put(element, treeMap.get(element) + 1);
    }

    return result;
  }
}
