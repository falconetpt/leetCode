package dp;

import java.util.HashMap;

public class DeepCopyLinkedList {
  public Node copyRandomList(Node head) {
    return copyRandomList(head, new HashMap<Node, Node>());
  }

  private Node copyRandomList(Node head, HashMap<Node, Node> integerNodeHashMap) {

    if (head == null) return null;
    if (integerNodeHashMap.containsKey(head)) return integerNodeHashMap.get(head);


    final var node = new Node(head.val);
    integerNodeHashMap.put(head, node);

    node.next = copyRandomList(head.next, integerNodeHashMap);
    node.random = copyRandomList(head.random, integerNodeHashMap);


    return node;
  }

  class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

}
