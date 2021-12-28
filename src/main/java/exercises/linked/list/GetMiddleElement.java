package exercises.linked.list;

public class GetMiddleElement {
  public ListNode middleNode(final ListNode head) {
    final var count = countSize(head);
    final var element = count / 2 + 1;

    return middleNode(head, 1, element);
  }

  private ListNode middleNode(final ListNode head, final int i, final int element) {
    if (i == element) {
      return head;
    } else {
      return middleNode(head.next, i + 1, element);
    }
  }

  private int countSize(final ListNode head) {
    if (head == null) {
      return 0;
    } else {
      return 1 + countSize(head.next);
    }
  }
}
