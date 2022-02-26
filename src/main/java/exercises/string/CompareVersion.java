package exercises.string;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class CompareVersion {
  public int compareVersion(final String version1,
                            final String version2) {
    final var version1Split = splitRevision(version1);
    final var version2Split = splitRevision(version2);

    while (!version1Split.isEmpty() || !version2Split.isEmpty()) {
      final var element1 = version1Split.isEmpty()
        ? 0
        : version1Split.pollFirst();

      final var element2 = version2Split.isEmpty()
        ? 0
        : version2Split.pollFirst();


      if (element1 != element2) return element1 < element2
        ? -1
        : 1;
    }

    return 0;
  }

  private LinkedList<Integer> splitRevision(final String version) {
    return Arrays.stream(version.split("\\."))
      .map(Integer::parseInt)
      .collect(Collectors.toCollection(LinkedList::new));
  }
}
