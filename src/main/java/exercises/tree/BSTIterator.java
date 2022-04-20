package exercises.tree;

import exercises.array.helper.TreeNode;

import java.util.LinkedList;

class BSTIterator {
    private final LinkedList<TreeNode> list;

    public BSTIterator(TreeNode root) {
        list = new LinkedList<>();
        constructBST(list, root);
    }

    public int next() {
        return list.pollFirst().val;
    }

    public boolean hasNext() {
        return !list.isEmpty();
    }

    private void constructBST(final LinkedList<TreeNode> list, final TreeNode node) {
        if (node != null) {
            constructBST(list, node.left);
            list.addLast(node);
            constructBST(list, node.right);

        }
    }
}