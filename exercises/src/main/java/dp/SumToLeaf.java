package dp;

import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

import dp.PathSum.*;

public class SumToLeaf {
  public int sumNumbers(TreeNode root) {
    if(root == null) return 0;
    return sumNumbers(root, 0, new AtomicInteger(0)).intValue();
  }

  public AtomicInteger sumNumbers(TreeNode root, int sum, AtomicInteger result) {
    if(root == null) {
      result.addAndGet(sum);
      return result;
    }

    new TreeMap<>()

    final var newSum = sum * 10 + root.val;

    if(root.left == null && root.right == null) {
      result.addAndGet(newSum);
    } else {
      if(root.left != null)sumNumbers(root.left, newSum, result);
      if(root.right != null)sumNumbers(root.right, newSum, result);
    }


    return result;
  }
}
