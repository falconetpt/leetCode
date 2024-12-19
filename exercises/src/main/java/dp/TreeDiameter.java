package dp;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class TreeDiameter {
  public int treeDiameter(Node node) {
    if (node == null) return 0;

    return  node.neighbours.stream()
        .map(this::calculateMaxDepth)
        .limit(2)
        .reduce(0, Integer::sum);
  }

  private int calculateMaxDepth(Node node) {
    if (node == null) return 0;
    return 1 + node.neighbours.stream()
        .map(this::calculateMaxDepth)
        .max(Comparator.comparingInt(a -> -a))
        .orElse(0);
  }

  private class Node {
    public int value;
    public List<Node> neighbours;
  }
}
