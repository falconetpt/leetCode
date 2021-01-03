package exercises.tree;

import exercises.array.helper.TreeNode;

public class ClonedNode {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (cloned == null) {
            return null;
        }  else {
            boolean sameNode = cloned.val == target.val;

            if (sameNode) {
                return cloned;
            } else {
                TreeNode right = getTargetCopy(original, cloned.right, target);

                return right != null ? right : getTargetCopy(original, cloned.left, target);
            }
        }
    }
}
