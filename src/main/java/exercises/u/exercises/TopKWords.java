package exercises.u.exercises;

import java.util.List;
import java.util.PriorityQueue;

public class TopKWords {
  public List<String> topKFrequent(String[] words, int k) {
    final var pq = new PriorityQueue<WordFrequency>();
    final var map =
    return
  }

  public record WordFrequency(String s, int frequency) {
  }
}
