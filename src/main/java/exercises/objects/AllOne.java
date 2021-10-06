package exercises.objects;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

public class AllOne {
  private final Map<String, Integer> count;
  private final NavigableMap<Integer, Set<String>> keysPerValue;

  public AllOne() {
    count = new HashMap<>();
    keysPerValue = new TreeMap<>();
  }

  public void inc(String key) {
    final var prev = count.getOrDefault(key, 0);
    count.put(key, prev + 1);
    keysPerValue.putIfAbsent(prev + 1, new HashSet<>());
    keysPerValue.get(prev + 1).add(key);
    keysPerValue.getOrDefault(prev, new HashSet<>()).remove(key);
    if (keysPerValue.get(prev).size() == 0) {
      keysPerValue.remove(prev);
    }
  }

  public void dec(String key) {
    final var prev = count.getOrDefault(key, 0);
    count.put(key, prev - 1);
    keysPerValue.putIfAbsent(prev - 1, new HashSet<>());
    keysPerValue.get(prev - 1).add(key);
    keysPerValue.getOrDefault(prev, new HashSet<>()).remove(key);
    if (keysPerValue.get(prev).size() == 0) {
      keysPerValue.remove(prev);
    }
  }

  public String getMaxKey() {
    return keysPerValue.size() == 0
      ? ""
      : keysPerValue.get(keysPerValue.lastKey())
      .stream()
      .findFirst()
      .orElse("");
  }

  public String getMinKey() {
    return keysPerValue.size() == 0
      ? ""
      : keysPerValue.get(keysPerValue.firstKey())
      .stream()
      .findFirst()
      .orElse("");
  }
}
