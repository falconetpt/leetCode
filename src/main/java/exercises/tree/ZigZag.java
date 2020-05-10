package exercises.tree;

import exercises.array.helper.TreeNode;

public class ZigZag {
    public int longestZigZag(TreeNode root) {
        return recursion(root,true,0);
    }

    public int recursion(TreeNode root, boolean isRight,int length){
        if(root == null){
            return length;
        } else {
            TreeNode next = isRight ? root.right : root.left;
            TreeNode makeParent = isRight ? root.left : root.right;
            int startParent = next != null ? recursion(next, !isRight,length + 1) : length;
            int startHere = makeParent != null ? recursion(makeParent,isRight,1) : 0;
            return Math.max(startParent, startHere);
        }
    }
}
