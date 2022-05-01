package exercises.array;

import java.awt.*;
import java.util.HashMap;

public class LongestArithSeqLength {
  public int longestArithSeqLength(final int[] nums) {
    var result = 2;

    for (int i = 0; i < nums.length; i++) {
      final var map = new HashMap<Integer, Point>();
      final var value = nums[i];
      for (int j = i + 1; j < nums.length; j++) {
        final var difference = nums[j] - value;
        final var mapValue = map.remove(difference);

        if (mapValue == null) {
          map.put(difference * 2, new Point(difference, 2));
          result = Math.max(2, result);
        } else {
          map.put(difference + mapValue.x, new Point(mapValue.x, mapValue.y + 1));
          result = Math.max(result, mapValue.y + 1);
        }
      }
    }


    return result;
  }
}
