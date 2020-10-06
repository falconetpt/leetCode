package exercises.tree;

import exercises.array.helper.TreeNode;

import java.util.Objects;

public class InsertTree {
    public TreeNode insertIntoBST(final TreeNode root,
                                  final int val) {
        insertIntoBSTRecursive( root, val );
        return root == null ? new TreeNode( val ) : root;
    }

    private void insertIntoBSTRecursive(TreeNode root, int val) {
        if (root != null) {
            System.out.println(root.val);
            if (root.val > val) {
                if (Objects.isNull(root.left)) {
                    root.left = new TreeNode( val );
                } else {
                    insertIntoBST( root.left, val );
                }
            } else {
                if (Objects.isNull(root.right)) {
                    root.right = new TreeNode( val );
                } else {
                    insertIntoBST( root.right, val );
                }
            }
        }
    }
}
