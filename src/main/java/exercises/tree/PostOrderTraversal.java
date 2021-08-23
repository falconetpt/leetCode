package exercises.tree;

import exercises.array.helper.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PostOrderTraversal {
  public List<Integer> preorderTraversal(final TreeNode root) {
    return preorderTraversal(root, new ArrayList<Integer>());
  }

  private List<Integer> preorderTraversal(final TreeNode root, final ArrayList<Integer> integers) {
    if (root == null) {
      return integers;
    } else {

      preorderTraversal(root.left, integers);
      preorderTraversal(root.right, integers);
      integers.add(root.val);

      return integers;
    }
  }
}
