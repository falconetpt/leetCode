package exercises.tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class NthTreeTraversal {
  public List<List<Integer>> levelOrder(final Node root) {
    final var result = new TreeMap<Integer, List<Integer>>(Comparator.comparing(k -> k));

    fillMap(root, 0, result);

    return new ArrayList<>(result.values());
  }

  private void fillMap(final Node root,
                       final int level,
                       final TreeMap<Integer, List<Integer>> result) {
    if (root != null) {
      result.putIfAbsent(level, new ArrayList<>());
      result.get(level).add(root.val);

      root.children.forEach(c -> fillMap(c, level + 1, result));
    }
  }

  class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, List<Node> _children) {
      val = _val;
      children = _children;
    }
  };
}
