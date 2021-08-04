package exercises.tree;

import exercises.array.helper.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumRootToLeaf {
  public List<List<Integer>> pathSum(final TreeNode root, final int targetSum) {
    final var result = new ArrayList<List<Integer>>();
    fillResult(root, targetSum, result, List.of());

    return result;
  }

  private void fillResult(final TreeNode root,
                          final int targetSum,
                          final List<List<Integer>> result,
                          final List<Integer> localList) {
    if (root != null) {
      final var value = root.val;
      final var newList = new ArrayList<>(localList);
      newList.add(value);

      if (targetSum - value == 0
        && root.left == null
        && root.right == null) {
        result.add(newList);
      } else {


        fillResult(root.left, targetSum - value, result, newList);
        fillResult(root.right, targetSum - value, result, newList);
      }
    }
  }
}
