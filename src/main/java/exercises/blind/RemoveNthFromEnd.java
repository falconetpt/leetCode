package exercises.blind;

import exercises.linked.list.ListNode;

import java.util.LinkedList;

public class RemoveNthFromEnd {
  public ListNode removeNthFromEnd(final ListNode head, int n) {
    final var list = createLinkedList(head, new LinkedList<>());

    if (n == list.size()) {
      return list.size() > 1
        ? list.pollFirst().next
        : null;
    }

    ListNode last = null;
    var count = 0;

    while (count < n - 1) {
      last = list.pollLast();
      count++;
    }

    list.pollLast();
    list.peekLast().next = last;

    return list.pollFirst();
  }

  private LinkedList<ListNode> createLinkedList(final ListNode head,
                                                final LinkedList<ListNode> listNodes) {
    if (head == null) {
      return listNodes;
    } else {
      listNodes.addLast(head);
      return createLinkedList(head.next, listNodes);
    }
  }
}
