package exercises.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

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
  //[9,24,9,32,11,19,25,8,18,2,12,2,9,6,11,5,16,9,19,12,14,6,12,5,12,3,0,10,0,7,8,4,0,0,4,3,2,0,1,0]
  //[10,27,10,35,12,22,28,8,19,2,12,2,9,6,12,5,17,9,19,12,14,6,12,5,12,3,0,10,0,7,8,4,0,0,4,3,2,0,1,0]
}
