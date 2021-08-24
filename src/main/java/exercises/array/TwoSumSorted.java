package exercises.array;

import java.util.HashMap;

public class TwoSumSorted {
  public int[] twoSum(int[] numbers, int target) {
    final var map = new HashMap<Integer, Integer>(  );

    for (int i = 0; i < numbers.length; i++) {
      final var value = numbers[i];
      final var dif =  target - value;

      if (map.containsKey( dif )) {
        return new int[] { map.get( dif ), i + 1};
      } else {
        map.put( value, i + 1 );
      }
    }

    return new int[] {};
  }
}
