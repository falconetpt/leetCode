package exercises.tree;

import exercises.array.helper.TreeNode;

public class PathSum {
    public int pathSum(final TreeNode root, final int sum) {
        return pathSum( root, sum, 0 );
    }

    private int pathSum(final TreeNode root, final int sum, final int acc) {
        if (root == null) {
            return 0;
        } else {
            int newAcc = acc + root.val;

            int left = pathSum( root.left, sum, newAcc ) + pathSum( root.left, sum, 0 );
            int right = pathSum( root.right, sum, newAcc ) + pathSum( root.right, sum, 0 );

            return (newAcc == sum ? 1  : 0) + left + right;
        }
    }
}
