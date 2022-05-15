package exercises.tree;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.SortedMap;

public class ConnectToRight {
  public Node connect(final Node root) {
    final var map = new LinkedHashMap<Integer, LinkedList<Node>>();

    fillList(root, map, 0);

    for (final var entry : map.values()) {
      var node = entry.pollFirst();

      while (!entry.isEmpty()) {
        node.next = entry.pollFirst();
        node = node.next;
      }
    }

    return root;
  }

  private void fillList(final Node root,
                        final LinkedHashMap<Integer, LinkedList<Node>> map,
                        final int i) {
    if (root != null) {
     map.putIfAbsent(i, new LinkedList<>());
     map.get(i).addLast(root);
     fillList(root.left, map, i + 1);
     fillList(root.right, map, i + 1);
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
  }
}
