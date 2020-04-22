package exercises.tree;

import exercises.array.helper.TreeNode;

public class FlipEquivalentBinaryTree {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (areNodesTheSame( root1, root2 )) {
            return isSwapPossible(root1, root2);
        } else {
            return false;
        }
    }

    private boolean isSwapPossible(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
          return true;
        } else if(!areNodesTheSame( root1, root2 )) {
            return false;
        } else if(areNodesTheSame( root1.left, root2.left )) {
            return isSwapPossible( root1.left, root2.left ) && isSwapPossible( root1.right, root2.right );
        } else {
            if ( areNodesTheSame( root1.left, root2.right ) &&  areNodesTheSame( root1.right, root2.left )) {
                TreeNode tmp = root1.right;
                root1.right = root1.left;
                root1.left = tmp;

                return isSwapPossible( root1.left, root2.left ) && isSwapPossible( root1.right, root2.right );
            } else {
                return false;
            }
        }
    }

    private boolean areNodesTheSame(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }


        if (root1.val == root2.val) {
            return true;
        } else {
            return false;
        }
    }


}
