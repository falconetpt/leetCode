package exercises.u.exercises;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AreSentencesSimilar {
  public boolean areSentencesSimilar(String sentence1, String sentence2) {
    final LinkedList<String> sentence1Split = Arrays.stream(sentence1.split(" "))
        .collect(Collectors.toCollection(LinkedList::new));
    final LinkedList<String> sentence2Split = Arrays.stream(sentence2.split(" "))
        .collect(Collectors.toCollection(LinkedList::new));

    while(true) {
      if (sentence1Split.isEmpty() || sentence2Split.isEmpty()) return true;

      if (Objects.equals(sentence1Split.peekFirst(), sentence2Split.peekFirst())) {
        sentence1Split.pollFirst();
        sentence2Split.pollFirst();
      } else if (Objects.equals(sentence1Split.peekLast(), sentence2Split.peekLast())) {
        sentence1Split.pollLast();
        sentence2Split.pollLast();
      } else {
        return false;
      }
    }
  }
}
