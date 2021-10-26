package exercises.blind;

import exercises.array.helper.TreeNode;

public class ValidBST {
  public boolean isValidBST(TreeNode root) {
    return solve(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  private boolean solve(TreeNode node, long lower, long upper){
    if(node == null) return true;
    if(node.val <= lower || node.val >= upper) return false;
    return solve(node.left, lower, node.val) && solve(node.right, node.val, upper);
  }
}
