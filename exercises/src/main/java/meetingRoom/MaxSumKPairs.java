package meetingRoom;

import java.util.HashMap;

public class MaxSumKPairs {
  public int maxOperations(int[] nums, int k) {
    final var map = getFrequency(nums);
    var count = 0;

    for (final var num : nums) {
      final var dif = k - num;

      final var isValid = dif == num
          ? map.getOrDefault(num, 0) > 1
          : map.getOrDefault(dif, 0) > 0 && map.getOrDefault(num, 0) > 0;


      if (isValid) {
        count++;
        map.put(dif, map.getOrDefault(dif, 0) - 1);
        map.put(num, map.getOrDefault(num, 0) - 1);
      }
    }

    return count;
  }

  private static HashMap<Integer, Integer> getFrequency(int[] nums) {
    final var map = new HashMap<Integer, Integer>();

    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    return map;
  }
}
