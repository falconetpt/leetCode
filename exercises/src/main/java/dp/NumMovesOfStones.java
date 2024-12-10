package dp;

import java.util.stream.Stream;

public class NumMovesOfStones {
  public int[] numMovesStones(int a, int b, int c) {
    final var sortedElements = Stream.of(a, b, c)
        .sorted()
        .toList();
    final var newA = sortedElements.get(0);
    final var newB = sortedElements.get(1);
    final var newC = sortedElements.get(2);
    final var fistElement = newC -newB -1;
    final var secondElement = newB-newA-1;
    var min = 2;

    if (fistElement == 0 && secondElement != 0) min = 1;
    if (fistElement != 0 && secondElement == 0) min = 1;
    if (fistElement == 1 || secondElement == 1) min = 1;
    if (fistElement == 0 && secondElement == 0 ) min = 0;



    return new int[] {
        min,
        fistElement + secondElement
    };
  }
}
