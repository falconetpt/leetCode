package exercises.string;

import java.util.Map;

public class BaloonString {
  public int maxNumberOfBalloons(final String text) {
    final var arr = new int[26];

    for (final var element : text.toCharArray()) {
      arr[element - 'a']++;
    }

    final var frequency = Map.of(
      'b', 1,
      'a', 1,
      'l', 2,
      'o', 2,
      'n', 1
    );

    return frequency.entrySet()
      .stream()
      .map(e -> arr[e.getKey() - 'a'] / e.getValue())
      .reduce(Integer.MAX_VALUE, Math::min);
  }
}
