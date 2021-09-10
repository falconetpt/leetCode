package exercises.string;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

public class Ordinals {
  private static final Map<Predicate<Integer>, String> MAP = initMap();
  private static final String DEFAULT_ORDINAL = "th";

  private static Map<Predicate<Integer>, String> initMap() {
    final var result = new LinkedHashMap<Predicate<Integer>, String>();
    result.put((i) -> Set.of(11, 12, 13).contains(i % 100), DEFAULT_ORDINAL);
    result.put((i) -> i % 10 == 1, "st");
    result.put((i) -> i % 10 == 2, "nd");
    result.put((i) -> i % 10 == 3, "rd");

    return result;
  }

  public String ordinals(final int i) {
    final var ordinal = MAP.entrySet().stream()
      .filter(e -> e.getKey().test(i))
      .map(Map.Entry::getValue)
      .findFirst()
      .orElse(DEFAULT_ORDINAL);

    return i + ordinal;
  }
}
