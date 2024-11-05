package exercises.u.exercises;

import java.util.stream.IntStream;

public class MinSubString {
  public int minChanges(final String s) {
    if (s.length() == 2) return  countChanges(s);

    var count = 0;

    for (int i = 0; i < s.length() -1; i+=2) {
      final var firstPart = s.substring(i, i + 2);

      System.out.println(firstPart);
      final var firstPartChange = countChanges(firstPart);
      count += firstPartChange;
    }

    return count;
  }

  private int countChanges(String s) {
    final var countOne = IntStream.range(0, s.length())
        .map(s::charAt)
        .filter(c -> c == '1')
        .count();

    return (int) (s.length() - Math.max(countOne, s.length() - countOne));
  }
}
