package dp;

import static dp. SumLinkedNode. ListNode;

public class RemoveFromEndNode {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    final var preNode = new ListNode();
    preNode.next = head;

    final var next = removeNthFromEnd(head, n, preNode);

    if (next.next == head) {
      return head.next;
    }

    next.next = next.next == null
      ? null
      : next.next.next;

    return head;
  }

  private ListNode removeNthFromEnd(ListNode head, int n, ListNode preNode) {
    if (head == null) return preNode;
    n--;
    if (n < 0) return removeNthFromEnd(head.next, n, preNode.next);
    return removeNthFromEnd(head.next, n, preNode);
  }
}
