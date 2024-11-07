package u.exercises;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class TopKWords {
  public List<String> topKFrequent(String[] words, int k) {
    final Comparator<WordFrequency> baseComparator = Comparator.comparing( a -> -a.frequency);
    final Comparator<WordFrequency> wordFrequencyComparator = baseComparator.thenComparing( a -> a.s);

    final var pq = new PriorityQueue<>(wordFrequencyComparator);
    final var map = new HashMap<String, WordFrequency>();

    for (final var word : words) {
      final var previous = map.getOrDefault(word, new WordFrequency(word, 0));
      map.put(word, new WordFrequency(previous.s, previous.frequency + 1));
    }

    pq.addAll(map.values());

    return IntStream.range(0, k)
        .boxed()
        .map(u -> pq.poll())
        .map(WordFrequency::s)
        .toList();
  }

  public record WordFrequency(String s, int frequency) {
  }
}
