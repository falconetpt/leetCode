package finalPrep;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class AlertNames {
  public List<String> alertNames(String[] keyName, String[] keyTime) {
    final var result = new TreeSet<String>();
    final var map = new HashMap<String, TreeSet<Integer>>();

    for (int i = 0; i < keyName.length; i++) {
      final var time = keyTime[i].split(":");
      final var key = keyName[i];
      final var timeInMinutes = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);

      if (!result.contains(key)) {
        map.putIfAbsent(key, new TreeSet<>());
        final var clashes = calculateClash(timeInMinutes, key, map.get(key));

        if (clashes > 2) result.add(key);
      }
    }

    return new ArrayList<>(result);
  }

  private int calculateClash(final int timeInMinutes, final String key, final TreeSet<Integer> integers) {
    integers.add(timeInMinutes);
    final var set = integers.subSet(timeInMinutes - 60, true,
        timeInMinutes, true);


    return set.stream()
        .map(s -> integers.subSet(s, true, s + 60, true).size())
        .max(Comparator.comparing(a -> a))
        .orElse(0);
  }
}
