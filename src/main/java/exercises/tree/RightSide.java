package exercises.tree;

import exercises.array.helper.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class RightSide {
  public List<Integer> rightSideView(final TreeNode root) {
    return rightSideView(root, new ArrayList<Integer>());
  }

  private List<Integer> rightSideView(final TreeNode root, final List<Integer> integers) {
    if (root == null) {
      return integers;
    } else {
      integers.add(root.val);
      return root.right == null
        ? rightSideView(root.left, integers)
        : rightSideView(root.right, integers);
    }
  }
}
