package exercises.tree;

import exercises.array.helper.TreeNode;

import java.util.PriorityQueue;

class BSTIterator {
    private PriorityQueue<Integer> iterator;

    public BSTIterator(TreeNode root) {
        iterator = new PriorityQueue<>(  );
        init(root);
    }

    /** @return the next smallest number */
    public int next() {
        return iterator.poll();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !iterator.isEmpty();
    }

    private void init(TreeNode root) {
        if(root != null) {
            iterator.add( root.val );
            init( root.left );
            init( root.right );
        }
    }
}