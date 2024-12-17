package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CloneGraph {
  public Node cloneGraph(Node node) {
    final var seenNodes = new HashMap<Integer, Node>();

    return cloneGraph(node, seenNodes, new HashSet<>());
  }

  private Node cloneGraph(Node node, HashMap<Integer, Node> seenNodes, HashSet<Integer> seen) {
    if (node == null) return null;
    if (seen.contains(node.val)) return seenNodes.get(node.val);

    seenNodes.putIfAbsent(node.val, new Node(node.val));
    seen.add(node.val);
    node.neighbors.stream().forEach(neighboor -> {
      seenNodes.putIfAbsent(neighboor.val, new Node(neighboor.val));
      seenNodes.get(node.val).neighbors.add(seenNodes.get(neighboor.val));
      cloneGraph(neighboor, seenNodes, seen);
    });

    return seenNodes.get(node.val);
  }


  class Node {
      public int val;
      public List<Node> neighbors;
      public Node() {
          val = 0;
          neighbors = new ArrayList<Node>();
      }
      public Node(int _val) {
          val = _val;
          neighbors = new ArrayList<Node>();
      }
      public Node(int _val, ArrayList<Node> _neighbors) {
          val = _val;
          neighbors = _neighbors;
      }
  }
}
