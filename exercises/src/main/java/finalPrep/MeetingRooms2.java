package finalPrep;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class MeetingRooms2 {
  public int canAttend(int[][] meetings) {
    Arrays.sort(meetings, Comparator.comparing(a -> a[0]));
    final var priorityQueue = new PriorityQueue<Integer>();
    priorityQueue.add(meetings[0][1]);


    for (int i = 1; i < meetings.length; i++) {
      final var value = meetings[i];

      if (value[0] >= priorityQueue.peek()) priorityQueue.poll();

      priorityQueue.add(value[1]);
    }

    return priorityQueue.size();
  }
}
