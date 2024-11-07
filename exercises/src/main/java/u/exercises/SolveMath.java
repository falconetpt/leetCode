package u.exercises;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class SolveMath {
  public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
    final var connectionMap = new HashMap<String, Map<String, Double>>();

    for (int i = 0; i < equations.size(); i++) {
      final var equation = equations.get(i);
      final var origin = equation.get(0);
      final var destination = equation.get(1);
      final var weight = values[i];

      connectionMap.putIfAbsent(origin, new HashMap<>());
      connectionMap.putIfAbsent(destination, new HashMap<>());

      connectionMap.get(origin).put(destination, weight);
      connectionMap.get(destination).put(origin, 1 / weight);
    }

    return calculateEquations(connectionMap, queries);
  }

  private double[] calculateEquations(HashMap<String, Map<String, Double>> connectionMap, List<List<String>> queries) {
    final var result = new double[queries.size()];
    for (int i = 0; i < queries.size(); i++) {
      final var query = queries.get(i);
      final var origin = query.get(0);
      final var destination = query.get(1);

      result[i] = calcEquation(connectionMap, origin, destination, new HashSet<String>());
      System.out.println("result = " + result[i]);
    }

    return result;
  }

  private double calcEquation(HashMap<String, Map<String, Double>> connectionMap, String origin, String destination, HashSet<String> seen) {
    System.out.println("origin = " + origin);
    System.out.println("destination = " + destination);
    System.out.println("connectionMap = " + connectionMap);

    if (connectionMap.containsKey(origin) && connectionMap.containsKey(destination)) {
      final var element = connectionMap.get(origin);

      if (element.containsKey(destination)) return element.get(destination);
      seen.add(origin);
      System.out.println("seen = " + seen);

      return element.entrySet()
          .stream()
          .filter(e -> !seen.contains(e.getKey()))
          .map(e -> e.getValue() * calcEquation(connectionMap, e.getKey(), destination, seen))
          .filter(v -> v >= 0)
          .max(Comparator.comparing(x -> x))
          .orElse(-1.0);
    } else {
      seen.add(origin);
      return -1;
    }
  }

}
