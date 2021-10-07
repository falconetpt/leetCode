package exercises.array;

import io.cucumber.java8.No;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindTheCity {
  public int findTheCity(int n, int[][] edges, int distanceThreshold) {
    final var map = IntStream.range(0, n)
      .boxed()
      .collect(Collectors.toMap(i -> i, (i) -> new Node(distanceThreshold)));

    for (int i = 0; i < edges.length; i++) {
      final var edge = edges[i];
      final var from = edge[0];
      final var to = edge[1];
      final var weight = edge[2];
      final var originNode = map.get(from);
      final var destinyNode = map.get(to);

      originNode.addEdge(new Edge(weight, destinyNode));
    }

    return map.entrySet()
      .stream()
      .sorted((a, b) -> -a.getKey().compareTo(b.getKey()))
      .max(Comparator.comparingInt(a -> a.getValue().edgeList.size()))
      .map(Map.Entry::getKey)
      .orElse(-1);
  }

  private class Node {
    private List<Edge> edgeList;
    private int distanceThreshold;

    public Node(final int distanceThreshold) {
      this.distanceThreshold = distanceThreshold;
      edgeList = new ArrayList<>();
    }

    public void addEdge(final Edge edge) {
      if (edge.weight <= distanceThreshold) edgeList.add(edge);
    }
  }

  private class Edge {
    private int weight;
    private Node node;

    public Edge(final int weight, final Node node) {
      this.node = node;
      this.weight = weight;
    }
  }
}
