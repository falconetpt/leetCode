package meetingRoom;

import java.util.LinkedList;
import java.util.stream.IntStream;

public class AsteroidCollision {
  public int[] asteroidCollision(int[] asteroids) {
    final var queue = new LinkedList<Integer>();
    queue.add(asteroids[0]);
    var left = 1;

    while (left < asteroids.length) {
      final var value = asteroids[left];

      if (queue.isEmpty()) {
        queue.add(value);
      } else {
        final var last = queue.peekLast();
        if (last > 0 && value < 0) {
          colideAsteoids(value, last, queue);
        } else {
          queue.add(value);
        }
      }
      left++;
    }

    final var result = new int[queue.size()];
    IntStream.range(0, result.length)
        .forEach(i ->result[i] = queue.get(i));

    return result;
  }

  private void colideAsteoids(int current, int last, LinkedList<Integer> queue) {
    final var absCurrent = Math.abs(current);
    final var absLast = Math.abs(last);


    while (!queue.isEmpty() && queue.peekLast() > 0 && absCurrent >= Math.abs(queue.peekLast())) {
      System.out.println(queue);
      if (absCurrent == queue.pollLast()) return;
    }

    if(queue.isEmpty() || Math.abs(current) > queue.peekLast()) queue.add(current);
  }
}
