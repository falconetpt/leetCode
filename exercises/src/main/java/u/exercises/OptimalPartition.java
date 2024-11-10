package u.exercises;

import java.util.Arrays;
import java.util.HashSet;

public class OptimalPartition {
  public int partitionString(String s) {
    var seen = new int[26];
    var count = 0;

    for (int i = 0; i < s.length(); i++) {
      final var element = s.charAt(i) - 'a';
      if (seen[element]++ > 0) {
        count++;
        seen = new int[26];
        seen[element]++;
      }
    }

    for (final var element : seen) {
      if (element == 1) return count + 1;
    }

    return count;
  }
}
