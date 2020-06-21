package exercises.array;

import exercises.array.helper.TreeNode;

import java.util.Objects;
import java.util.stream.Stream;

public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        } else {
            final TreeNode result = new TreeNode( root.val );

            invertTree( root, result );

            return result;
        }
    }

    private void invertTree(TreeNode originalNode, TreeNode newNode) {
        boolean validNodes = Stream.of(originalNode, newNode).allMatch( Objects::nonNull );

        if (validNodes) {
            if (originalNode.left != null) newNode.right = new TreeNode( originalNode.left.val );
            if (originalNode.right != null) newNode.left = new TreeNode( originalNode.right.val );

            invertTree( originalNode.left, newNode.right );
            invertTree( originalNode.right, newNode.left );
        }
    }
}
