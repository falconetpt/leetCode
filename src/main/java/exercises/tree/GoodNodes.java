package exercises.tree;

import exercises.array.helper.TreeNode;

public class GoodNodes {
        public int goodNodes(TreeNode root) {
            return goodNodes( root, Integer.MIN_VALUE );
        }

        private int goodNodes(TreeNode root, int maxValue) {
            if (root == null) {
                return 0;
            } else {
                int value = root.val;
                int isGoodNode = value >= maxValue ? 1 : 0;
                int newMax = Math.max( value, maxValue );
                return isGoodNode + goodNodes( root.left, newMax) + goodNodes( root.right, newMax );
            }
        }

    /**
     * https://leetcode.com/problems/count-good-nodes-in-binary-tree/
     *
     * Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.
     *
     * Return the number of good nodes in the binary tree.
     *
     *
     *
     * Example 1:
     *
     *
     *
     * Input: root = [3,1,4,3,null,1,5]
     * Output: 4
     * Explanation: Nodes in blue are good.
     * Root Node (3) is always a good node.
     * Node 4 -> (3,4) is the maximum value in the path starting from the root.
     * Node 5 -> (3,4,5) is the maximum value in the path
     * Node 3 -> (3,1,3) is the maximum value in the path.
     * Example 2:
     *
     *
     *
     * Input: root = [3,3,null,4,2]
     * Output: 3
     * Explanation: Node 2 -> (3, 3, 2) is not good, because "3" is higher than it.
     * Example 3:
     *
     * Input: root = [1]
     * Output: 1
     * Explanation: Root is considered as good.
     */
}
