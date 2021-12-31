package exercises.array.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ConnectNodes {
  public Node connect(final Node root) {
    final var levels = connect(root, new ArrayList<LinkedList<Node>>(), 0);

    for (final var level : levels) {
      var element = level.pollFirst();

      while (!level.isEmpty()) {
        final var next = level.pollFirst();
        element.next = next;
        element = next;
      }
    }

    return root;
  }

  private List<LinkedList<Node>> connect(final Node root, final List<LinkedList<Node>> levels, final int level) {
    if (root == null) {
      return levels;
    } else {
      if (levels.size() < level + 1) levels.add(new LinkedList<>());
      levels.get(level).addLast(root);
      connect(root.left, levels, level + 1);
      connect(root.right, levels, level + 1);
      return levels;
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
