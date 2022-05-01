package exercises.array;

import java.util.HashMap;

public class MinNumberOfCards {
  public int minimumCardPickup(final int[] cards) {
    var max = cards.length;
    var seen = false;
    final var seenMap = new HashMap<Integer, Integer>();

    for (int i = 0; i < cards.length; i++) {
      final var card = cards[i];

      if (seenMap.containsKey(card)) {
        seen = true;
        max = Math.min(max, i - seenMap.get(card) + 1);

      }
      seenMap.put(card, i);

    }

    return seen
      ? max
      : -1;
  }
}
