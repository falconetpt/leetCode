package exercises.string;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomOrder {
  public String customSortString(String order, String str) {
    final var frequency = Arrays.stream(str.split(""))
      .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    final var result = new StringBuilder();

    Arrays.stream(order.split(""))
      .forEach(s -> {
        final var c = frequency.getOrDefault(s, 0L);

        for (int i = 0; i < c; i++) {
          result.append(s);
        }

        frequency.remove(s);
      });

    frequency.entrySet()
      .stream()
      .forEach(e -> {
        for (int i = 0; i < e.getValue(); i++) {
          result.append(e.getKey());
        }
      });

    return result.toString();
  }
}
