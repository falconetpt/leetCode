package exercises.u.exercises;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

public class NumBusesToTarget {
  private final Map<Integer, Set<BusConnection>> connections = new HashMap<>();

  public int numBusesToDestination(int[][] routes, int source, int target) {

    if (source == target) return 0;

    fillConnetions(routes);

    final var startingPoint = connections.getOrDefault(source, Set.of());
    final var priorityQueue = new PriorityQueue<BusWeight>(Comparator.comparing(a -> a.weight));
    startingPoint.stream()
        .map(bc -> new BusWeight(0, bc))
        .forEach(priorityQueue::add); // Base line to apply Djistra algo

    final var seen = new HashSet<Integer>();
    seen.add(source);

    return calculateMinRides(priorityQueue, seen, target);
  }

  private int calculateMinRides(PriorityQueue<BusWeight> priorityQueue, HashSet<Integer> seen, int target) {
    while (!priorityQueue.isEmpty()) {
      final var element = priorityQueue.poll();
      final var busConnections = element.busConnection;

      if (busConnections.route == target) return element.weight;

      seen.add(busConnections.route);

      busConnections.connections.stream()
          .filter(route -> !seen.contains(route))
          .flatMap(route -> connections.getOrDefault(route, Set.of()).stream())
          .map(bc -> new BusWeight(element.weight + 1, bc))
          .forEach(priorityQueue::add);

    }

    return -1;
  }

  private void fillConnetions(int[][] routes) {
    for (int i = 0; i < routes.length; i++) {
      for (int j = 0; j < routes[i].length; j++) {
        int stop = routes[i][j];
        connections.putIfAbsent(stop, new HashSet<>());

        final var newBusConnection = new BusConnection();
        newBusConnection.route = stop;
        newBusConnection.addAll(routes[i]);

        connections.get(stop).add(newBusConnection);
      }
    }
  }

  private class BusWeight {
    public Integer weight;
    public BusConnection busConnection;

    public BusWeight(int weight, BusConnection busConnection) {
      this.weight = weight;
      this.busConnection = busConnection;
    }
  }


  private class BusConnection {
    public int route;
    public Set<Integer> connections = new HashSet<>();

    public void addAll(int routes[]) {
      Arrays.stream(routes).forEach(connections::add);
      connections.remove(route);
    }
  }
}
