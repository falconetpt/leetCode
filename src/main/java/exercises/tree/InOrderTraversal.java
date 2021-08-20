package exercises.tree;

import exercises.array.helper.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InOrderTraversal {
  public List<Integer> inorderTraversal(TreeNode root) {
    return inorderTraversal(root, new ArrayList<Integer>());
  }

  private List<Integer> inorderTraversal(final TreeNode root, final List<Integer> integers) {
    if (root == null) {
      return integers;
    } else {

      inorderTraversal(root.left, integers);

      integers.add(root.val);

      inorderTraversal(root.right, integers);

      return integers;
    }
  }
}
