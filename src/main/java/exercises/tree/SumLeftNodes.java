package exercises.tree;

import exercises.array.helper.TreeNode;

import java.util.Optional;

public class SumLeftNodes {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int value = Optional.ofNullable(root.left)
                    .filter( x -> x.left == null && x.right == null )
                    .map( x -> x.val )
                    .orElse( 0 );
            return value + sumOfLeftLeaves( root.left ) + sumOfLeftLeaves( root.right );
        }
    }
}
