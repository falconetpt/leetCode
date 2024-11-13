package meetingRoom;

import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class FairPair {
  public long countFairPairs(int[] nums, int lower, int upper) {
    final var treeMap = new TreeMap<Integer, Integer>();
    var count = 0l;

    for (int i = 0; i < nums.length; i++) {
      final var num = nums[i];
      final var top = upper - num;
      final var bottom = lower - num;


      count += treeMap.subMap(Math.min(top, bottom), true, Math.max(top, bottom), true)
          .values()
          .stream()
          .reduce(0, Integer::sum);

      treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);

    }

    return count;
  }
}
