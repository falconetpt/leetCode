package meetingRoom;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRoom {
  public boolean canAttendAll(int[][] meeting) {
    Arrays.sort(meeting, Comparator.comparing(a -> a[0])); // Order by first element

    for (int i = 1; i < meeting.length; i++) {
      final var prev = meeting[i-1];
      final var current = meeting[i];

      if (prev[1] >= current[0]) return false;
    }

    return true;
  }
}
