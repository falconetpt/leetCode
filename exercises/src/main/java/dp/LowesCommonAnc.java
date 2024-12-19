package dp;

import java.util.HashSet;

public class LowesCommonAnc {

  public Node lowstCommonAncestor(Node root, Node p, Node q) {
    return lowstCommonAncestor(root, p, q, new HashSet<Node>());
  }

  private Node lowstCommonAncestor(Node root, Node p, Node q, HashSet<Node> nodes) {
    if (root == null) return null;



    lowstCommonAncestor(root.left, p, q, nodes);
    lowstCommonAncestor(root.right, p, q, nodes);

    nodes.add(root);

    if (nodes.contains(p) && nodes.contains(q)) return root;

    return null;
  }

  class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
  }
}
