package meetingRoom;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CloseStrings {
  public boolean closeStrings(String word1, String word2) {
    if (word1.length() != word2.length()) return false;
    final var word1Frequency = getFrequency(word1);
    final var word2Frequency = getFrequency(word2);

    final var allValues = new HashSet<>(word1Frequency.keySet());
    allValues.addAll(word2Frequency.keySet());

    final var nonMatched = new HashSet<Character>();

    for (final var value : allValues) {
      final var word1Value = word1Frequency.getOrDefault(value, 0);
      final var word2Value = word2Frequency.getOrDefault(value, 0);

      if (word1Value == 0 || word2Value == 0) return false;
      if (word1Value != word2Value) {
        nonMatched.add(value);
      }
    }

    final var swap1 = new HashMap<Integer, Integer>();
    final var swap2 = new HashMap<Integer, Integer>();


    for (final var value: nonMatched) {
      final var word1Value = word1Frequency.get(value);
      final var word2Value = word2Frequency.get(value);

      swap1.put(word1Value, swap1.getOrDefault(word1Value, 0) + 1);
      swap2.put(word2Value, swap2.getOrDefault(word2Value, 0) + 1);

    }

    return swap1.equals(swap2);
  }

  private Map<Character, Integer> getFrequency(final String word1) {
    final var result = new HashMap<Character, Integer>();

    for (int i = 0; i < word1.length(); i++) {
      final var word = word1.charAt(i);
      result.put(word, result.getOrDefault(word, 0) + 1);
    }

    return result;
  }
}
