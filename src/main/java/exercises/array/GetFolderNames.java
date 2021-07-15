package exercises.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GetFolderNames {
  public String[] getFolderNames(String[] names) {
    return getFolderNames(names, 0, new HashSet<String>(), new ArrayList<String>());
  }

  private String[] getFolderNames(final String[] names,
                                  final int i,
                                  final Set<String> strings,
                                  final List<String> stringArrayList) {
    if (i >= names.length) {
      return stringArrayList.toArray(String[]::new);
    } else {
      final var value = names[i];

      if (strings.contains(value)) {
        IntStream.iterate(1, x -> x + 1)
          .mapToObj(x -> String.format("%s(%d)", value, x))
          .filter(s -> !stringArrayList.contains(s))
          .findFirst()
          .ifPresent(s -> {
            strings.add(s);
            stringArrayList.add(s);
          });
      } else {
        strings.add(value);
        stringArrayList.add(value);
      }

      return getFolderNames(names, i + 1, strings, stringArrayList);
    }
  }
}
