package exercises.u.exercises;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingScheduler {
  public int[] meetingScheduler(final int[][] slot1, final int[][] slot2, int duration) {
    final var pqSlot1 = new PriorityQueue<int[]>(Comparator.comparing(s -> s[0]));
    final var pqSlot2 = new PriorityQueue<int[]>(Comparator.comparing(s -> s[0]));
    pqSlot1.addAll(Arrays.asList(slot1));
    pqSlot2.addAll(Arrays.asList(slot2));

    while (!pqSlot1.isEmpty() && !pqSlot2.isEmpty()) {
      final var nextSlot1Avaliability = pqSlot1.peek();
      final var nextSlot2Avaliability = pqSlot2.peek();

      final var overLap = overlapInterval(nextSlot1Avaliability, nextSlot2Avaliability);

      if (overLap[1] - overLap[0] >= duration) return new int[] { overLap[0], overLap[0] + duration };

      final var slot1IsBigger = nextSlot1Avaliability[1] >= nextSlot2Avaliability[1];

      if (slot1IsBigger) {
        pqSlot2.poll();
      } else {
        pqSlot1.poll();
      }
    }

    return new int[] {};
  }

  private int[] overlapInterval(int[] nextSlot1Avaliability, int[] nextSlot2Avaliability) {
    final var startSlot1 = nextSlot1Avaliability[0];
    final var endSlot1 = nextSlot1Avaliability[1];
    final var startSlot2 = nextSlot2Avaliability[0];
    final var endSlot2 = nextSlot2Avaliability[1];

    return new int[] { Math.max(startSlot1, startSlot2), Math.min(endSlot1, endSlot2)};
  }
}
