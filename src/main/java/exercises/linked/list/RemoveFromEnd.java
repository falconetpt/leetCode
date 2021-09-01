package exercises.linked.list;

import java.util.LinkedList;

public class RemoveFromEnd {
  public ListNode removeNthFromEnd(final ListNode head, final int n) {
    return removeNthFromEnd(head, n, new LinkedList<ListNode>());
  }

  private ListNode removeNthFromEnd(final ListNode head, final int n, final LinkedList<ListNode> listNodes) {
    if (head == null) {
      if (listNodes.size() > n) {
        final var node = listNodes.pollFirst();
        node.next = node.next == null
          ? null
          : node.next.next;
        return node;
      }
      return null;
    } else {
      if (listNodes.size() > n) {
        listNodes.pollFirst();
      }
      listNodes.addLast(head);
      removeNthFromEnd(head.next, n, listNodes);
      return head;
    }
  }
}
