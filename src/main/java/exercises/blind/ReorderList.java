package exercises.blind;

import exercises.linked.list.ListNode;

import java.util.LinkedList;

public class ReorderList {
  public void reorderList(final ListNode head) {
    final var list = constructList(head.next, new LinkedList<>());
    var prev = head;
    var first = false;

    while (!list.isEmpty()) {
      prev.next = first
        ? list.pollFirst()
        : list.pollLast();
      prev = prev.next;
      first = !first;
    }

    prev.next = null;
  }

  private LinkedList<ListNode> constructList(final ListNode head,
                                             final LinkedList<ListNode> nodes) {
    if (head == null) {
      return nodes;
    } else {
      nodes.addLast(head);
      return constructList(head.next, nodes);
    }
  }
}
