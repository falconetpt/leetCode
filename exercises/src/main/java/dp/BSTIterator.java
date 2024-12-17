package dp;

import java.util.LinkedList;

import static dp.PathSum.TreeNode.;

public class BSTIterator {
  private LinkedList<Integer> iterator;

  public BSTIterator(TreeNode root) {
    iterator = new LinkedList<>();
    iterate(root, iterator);
  }

  public int next() {
    return iterator.pollFirst();
  }

  public boolean hasNext() {
    return !iterator.isEmpty();
  }


  private void iterate(TreeNode root, LinkedList<Integer> iterator) {
    if (root != null) {
      iterate(root.left, iterator);
      iterator.addLast(root.val);
      iterate(root.right, iterator);
    }
  }

}
