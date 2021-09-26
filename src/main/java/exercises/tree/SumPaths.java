package exercises.tree;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class SumPaths {
  public int[] sumOfDistancesInTree(final int n, final int[][] edges) {
    final var map = new HashMap<Integer, TreeNode>();
    IntStream.range(0, n)
      .forEach(i -> map.put(i, new TreeNode(i)));

    for (int i = 0; i < edges.length; i++) {
      final var element = edges[i];
      final var parentIndex = element[0];
      final var childIndex = element[1];
      final var child = map.get(childIndex);
      final var parent = map.get(parentIndex);

      child.parent = parent;
      parent.nodes.add(child);

      parent.parent = child;
      child.nodes.add(parent);
    }

    return IntStream.range(0, n)
      .map(i -> sum(map.get(i), 0, new HashSet<>()))
      .toArray();
  }

  private int sum(final TreeNode treeNode, final int i, final Set<TreeNode> seen) {
    if (treeNode == null || seen.contains(treeNode)) {
      return 0;
    } else {
      seen.add(treeNode);
      System.out.println("treeNode.val = " + treeNode.val);
      return i
        + treeNode.nodes.stream()
          .map(n -> sum(n, i + 1, new HashSet<>(seen)))
          .reduce(0, Integer::sum)
        + sum(treeNode.parent, i + 1, new HashSet<>(seen));
    }
  }

  public class TreeNode {
    public int val;
    private List<TreeNode> nodes;
    public TreeNode parent;

    public TreeNode(int x) {
      val = x;
      nodes = new ArrayList<>();
    }
  }

}
