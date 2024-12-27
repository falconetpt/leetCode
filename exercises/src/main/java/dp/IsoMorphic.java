package dp;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IsoMorphic {
  public boolean isIsomorphic(String s, String t) {
    final var mapS = getMapFrequency(s);
    final var mapT = getMapFrequency(t);

    return mapS.equals(mapT);
  }

  private Map<Integer, Integer> getMapFrequency(String s) {
    final var map = new HashMap<Integer, Integer>();
    final var frequency = IntStream.range(0, s.length())
        .boxed()
        .map(s::charAt)
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    for (final var entry : frequency.values()) {
      map.put(entry.intValue(), map.getOrDefault(entry.intValue(), 0) + 1);
    }

    return map;
  }
}
