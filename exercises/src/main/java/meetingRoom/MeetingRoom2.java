package meetingRoom;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;

public class MeetingRoom2 {
  public int minNumOfMeetingRooms(int[][] meeting) {
    Arrays.sort(meeting, Comparator.comparing(a -> a[0])); // Order by first element
    final var map = new PriorityQueue<Integer>();
    map.add(meeting[0][1]);

    for (int i = 1; i < meeting.length; i++) {
      final var start = meeting[i][0];
      final var end = meeting[i][1];

      if (start >= map.peek()) map.poll();

      map.add(end);
    }

    return map.size();
  }
}
