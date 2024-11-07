package u.exercises;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class TextJustification {
  public List<String> fullJustify(String[] words, int maxWidth) {
    final var result = new ArrayList<String>();
    final var queue = new LinkedList<String>();
    var count = 0;

    for (int i = 0; i < words.length; i++) {
      final var word = words[i];
//      System.out.println(word);
      if (maxWidth >= count + word.length() + 1) {
        queue.add(word);
        count += word.length() + 1;
      } else {
        result.add(generateWord(queue, maxWidth));
        queue.add(word);
        count = word.length();
      }
    }

    if(!queue.isEmpty()) {
      final var resultString = queue.stream().collect(Collectors.joining(" "));
      result.add(resultString + " ".repeat(maxWidth - resultString.length()));
    }

    return result;
  }

  private String generateWord(LinkedList<String> queue, int maxWidth) {

    if(queue.size() == 1) {
      final var firstElement = queue.pollFirst();
      return firstElement + " ".repeat(maxWidth - firstElement.length());
    }

    if (queue.size() == 2) {
      final var firstElement = queue.pollFirst();
      final var secElement = queue.pollFirst();

      final var start = firstElement + " " + secElement;

      return start + " ".repeat(maxWidth - start.length());
    }

    final var count = queue.stream()
        .map(String::length)
        .reduce(0, Integer::sum);

    final var spaces = (maxWidth - count) / (queue.size() - 1);
    var result = queue.pollLast();

    while (queue.size() > 1) {
      result = queue.pollLast() + " ".repeat(spaces)  + result;
    }

    final var firstElement = queue.pollFirst();
    return firstElement + " ".repeat(maxWidth - (firstElement.length() + result.length())) + result;
  }
}
