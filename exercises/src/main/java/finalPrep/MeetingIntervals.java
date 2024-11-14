package finalPrep;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingIntervals {
  public boolean canAttend(int[][] meetings) {
    Arrays.sort(meetings, Comparator.comparing(a -> a[0]));
    var last = meetings[0];

    for (int i = 1; i < meetings.length; i++) {
      final var current = meetings[i];

      if (current[0] < last[1]) return false;
      last = current;
    }

    return true;
  }
}
