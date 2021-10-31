package exercises.linked.list;

import java.util.LinkedList;

public class Flatten {
  public Node flatten(final Node head) {
    final var list = flatten(head, new LinkedList<Node>());
    final var first = list.pollFirst();
    var current = first;
    Node prev = null;

    for (final var node : list) {
      current.next = node;
      current.prev = prev;
      current.child = null;
      node.next = null;
      node.child = null;
      node.prev = current;
      prev = current;
      current = node;
    }

    return first;
  }

  private LinkedList<Node> flatten(final Node head,
                                   final LinkedList<Node> nodes) {
    if (head == null) {
      return nodes;
    } else {
      nodes.add(head);
      flatten(head.child, nodes);
      return flatten(head.next, nodes);
    }
  }

  class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
  };
}
