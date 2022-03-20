package exercises.linked.list;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
  public Node copyRandomList(final Node head) {
    final var map = new HashMap<Node, Node>();
    fillNodes(head, map);

    copyRandomList(head, map);

    return map.getOrDefault(head, null);
  }

  private void copyRandomList(final Node head,
                              final Map<Node, Node> map) {
    if (head != null) {
      final var element = map.get(head);
      final var randomElement = head.random == null
        ? null
        : map.get(head.random);
      final var nextElement = head.next == null
        ? null
        : map.get(head.next);

      element.random = randomElement;
      element.next = nextElement;
      copyRandomList(head.next, map);
    }
  }

  private void fillNodes(final Node head,
                         final Map<Node, Node> map) {
    if (head != null) {
      map.put(head, new Node(head.val));
      fillNodes(head.next, map);
    }
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
