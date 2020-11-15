package exercises.tree;

import exercises.array.helper.TreeNode;

public class SumRange {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        } else {
            System.out.println(root.val);
            boolean inRange = root.val >= low && root.val <= high;
            int rightSum = root.val >= low ? rangeSumBST( root.left, low, high ) : 0;
            int leftSum = root.val <= high ? rangeSumBST( root.right, low, high ) : 0;

            return inRange ? root.val + leftSum + rightSum : leftSum + rightSum;
        }
    }
}
