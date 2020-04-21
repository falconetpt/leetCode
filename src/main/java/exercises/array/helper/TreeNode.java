package exercises.array.helper;

public class TreeNode {
    public int val;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int x) { val = x; }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
