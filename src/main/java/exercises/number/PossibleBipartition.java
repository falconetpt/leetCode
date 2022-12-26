package exercises.number;

import java.util.HashSet;

public class PossibleBipartition {
  public boolean possibleBipartition(int n, int[][] dislikes) {
    final var group1 = new HashSet<Integer>();
    final var group2 = new HashSet<Integer>();

    for (final var dislike : dislikes) {
      final var origin = dislike[0];
      final var dest = dislike[1];

      if (group1.contains(dest) || group2.contains(origin)) {

      } else {
        group1.add(origin);
        group2.add(dest);
      }
    }

    return group1.stream()
      .noneMatch(group2::contains);
  }
}
