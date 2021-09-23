package exercises.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ConnectNodes {
  public Node connect(Node root) {
    final var map = new HashMap<Integer, List<Node>>();
    fillNode(root, map, 0);

    for (final var list : map.values()) {
      for (int i = 1; i < list.size(); i++) {
        final var node = list.get(i - 1);
        node.next = list.get(i);
      }
    }

    return root;
  }

  private void fillNode(final Node root, final HashMap<Integer, List<Node>> map, final int level) {
    if (root != null) {
      map.putIfAbsent(level, new ArrayList<>());
      map.get(level).add(root);
      fillNode(root.left, map, level + 1);
      fillNode(root.right, map, level + 1);
    }
  }

  class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
      val = _val;
      left = _left;
      right = _right;
      next = _next;
    }
  };
}
