package dp;

import static dp.SumLinkedNode.ListNode;

public class AddTwoNumbers3 {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    return join(l1, l2, 0);
  }

  private ListNode join(ListNode l1, ListNode l2, int remainder) {
    if (l1 == null && l2 == null) return remainder == 0 ? null : new ListNode(remainder);

    final var l1Value = l1 == null
        ? 0
        : l1.val;

    final var l2Value = l2 == null
        ? 0
        : l2.val;

    final var newTotal = l1Value + l2Value + remainder;

    final var element = new ListNode(newTotal % 10);

    element.next = join(l1 == null ? null : l1.next, l2 == null ? null : l2.next, newTotal / 10);

    return element;
  }
}
