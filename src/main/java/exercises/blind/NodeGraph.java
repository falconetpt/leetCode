package exercises.blind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class NodeGraph {
  public Node cloneGraph(Node node) {

    if(node == null) return null;
    final var map = new HashMap<Integer, Node>();
    final var result = new Node(node.val);
    map.put(node.val, result);

    var baseNode = result;
    var nextNode = node.neighbors;

    fillNodes(baseNode, nextNode, map);

    return result;
  }

  private void fillNodes(final Node baseNode,
                         final List<Node> nextNode,
                         final HashMap<Integer, Node> map) {
    for (final var node : nextNode) {
      if (map.containsKey(node.val)) {
        baseNode.neighbors.add(map.get(node.val));
      } else {
        final var newNode = new Node(node.val);
        map.put(node.val, newNode);
        baseNode.neighbors.add(newNode);

        fillNodes(newNode, node.neighbors, map);
      }
    }
  }

  class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
      val = 0;
      neighbors = new ArrayList<>();
    }
    public Node(int _val) {
      val = _val;
      neighbors = new ArrayList<>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
      val = _val;
      neighbors = _neighbors;
    }
  }
}
