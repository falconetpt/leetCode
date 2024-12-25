package dp;

import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IsSubSequenceStr {
  public boolean isSubsequence(String s, String t) {
    final var queue = IntStream.range(0, s.length())
        .boxed()
        .map(s::charAt)
        .collect(Collectors.toCollection(LinkedList::new));

    for (int i = 0; i < t.length(); i++) {
      if (queue.isEmpty()) return true;
      final var element = t.charAt(i);

      if (queue.peekFirst() == element) queue.pollFirst();
    }

    return queue.isEmpty();
  }
}
