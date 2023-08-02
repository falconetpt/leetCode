package exercises.tree;

import exercises.array.helper.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DistanceK {
  public List<Integer> distanceK(final TreeNode root,
                                 final TreeNode target,
                                 final int k) {
    final var map = new HashMap<TreeNode, List<TreeNode>>();

    fillMap(root, null, map);

    final var list = expandTree(target, k, new HashSet<>(), map, new HashSet<>());

    return new ArrayList<>(list);
  }

  private void fillMap(final TreeNode root,
                       final TreeNode parent,
                       final Map<TreeNode, List<TreeNode>> map) {
    if (root != null) {
      map.put(root,
        Stream.of(parent, root.left, root.right).collect(Collectors.toList())
      );
      fillMap(root.left, root, map);
      fillMap(root.right, root, map);
    }
  }

  private Set<Integer> expandTree(final TreeNode target,
                                  final int k,
                                  final Set<Integer> result,
                                  final Map<TreeNode, List<TreeNode>> map,
                                  final Set<TreeNode> seen) {
    if (target == null || seen.contains(target)) {
      return result;
    } else if (k == 0) {
      result.add(target.val);
      return result;
    } else {
      seen.add(target);
      map.getOrDefault(target, new ArrayList<>())
        .forEach(e -> expandTree(e, k -1, result, map, seen));
      map.remove(target);
      return result;
    }
  }


}
