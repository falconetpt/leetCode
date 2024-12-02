package u.exercises;

import java.util.LinkedList;

public class KThSmallesBST {
  public int kthSmallest(TreeNode root, int k) {
    final var list = new LinkedList<Integer>();

    return searchKthSmallest(root, k, list);
  }

  private int searchKthSmallest(TreeNode root, int k, LinkedList<Integer> list) {
    if (root == null) {
      return -1;
    } else {
      searchKthSmallest(root.left, k, list);
      list.add(root.val);
      if (list.size() >= k) return list.get(k - 1);

      return searchKthSmallest(root.right, k, list);
    }
  }


  public class TreeNode {
        public int val;
        public TreeNode left;
       public TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
