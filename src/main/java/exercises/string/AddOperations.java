package exercises.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class AddOperations {
  private final static Map<Character, BiFunction<Integer, Integer, Integer>> MAP = Map.of(
    '+', Integer::sum,
    '-', (Integer a,  Integer b) -> a - b,
    '*', (Integer a,  Integer b) -> a * b,
    (char) 0, (Integer a,  Integer b) -> a * 10 + b
  );


  public List<String> addOperators(final String num, final int target) {
    var valueToOperations = new HashMap<Integer, List<String>>();
    final var firstValue = num.charAt(num.length() - 1) - '0';
    valueToOperations.put(firstValue, new ArrayList<>() {{ add(String.valueOf(firstValue)); }});

    for (int i = num.length() - 2; i >= 0 ; i--) {
      final var value = num.charAt(i) - '0';

      final var newMap = new HashMap<Integer, List<String>>();

      for (final var entry : MAP.entrySet()) {
        for (final var valueToOperation : valueToOperations.entrySet()) {
          final var newOperations = new ArrayList<String>();

          for (final var operation : valueToOperation.getValue()) {
            newOperations.add(String.valueOf(value) + entry.getKey() + operation);
          }

          final var operationResult = entry.getValue().apply(value, valueToOperation.getKey());
          newMap.putIfAbsent(operationResult, new ArrayList<>());
          newMap.get(operationResult).addAll(newOperations);
        }

      }

      valueToOperations = newMap;
    }

    return valueToOperations.getOrDefault(target, List.of());
  }

}
