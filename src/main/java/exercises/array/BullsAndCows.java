package exercises.array;

import java.util.HashMap;

public class BullsAndCows {
  public String getHint(final String secret, final String guess) {
    var bullCount = 0;
    final var secretMap = new HashMap<Character, Integer>();
    final var guessMap = new HashMap<Character, Integer>();

    for (int i = 0; i < secret.length(); i++) {
      final var secretChar = secret.charAt(i);
      final var guessChar = guess.charAt(i);

      if (secretChar == guessChar) {
        bullCount++;
      } else {
        secretMap.put(secretChar, secretMap.getOrDefault(secretChar, 0) + 1);
        guessMap.put(guessChar, guessMap.getOrDefault(guessChar, 0) + 1);
      }
    }

    final var cowCount = guessMap.keySet()
      .stream()
      .filter(secretMap::containsKey)
      .mapToInt(k -> Math.min(guessMap.getOrDefault(k, 0), secretMap.getOrDefault(k, 0)))
      .sum();

    return String.format("%dA%dB", bullCount, cowCount);
  }
}
