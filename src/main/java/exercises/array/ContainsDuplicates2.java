package exercises.array;

import java.util.HashMap;

public class ContainsDuplicates2 {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    final var latestSeen = new HashMap<Integer, Integer>(  );

    for (int i = 0; i < nums.length; i++) {
      final var value = nums[i];
      if (latestSeen.containsKey( value )
        && i - latestSeen.get( value )<= k) {
        return true;
      }

      latestSeen.put( value, i );
    }

    return false;
  }
}
