package dp;

public class SumLinkedNode {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    return addTwoNumbers(l1, l2, 0);
  }

  private ListNode addTwoNumbers(ListNode l1, ListNode l2, int remainder) {
    if (l1 == null && l2 == null) return remainder > 0
        ? new ListNode(remainder)
        : null;
    final var value1 = l1 == null
        ? 0
        : l1.val;

    final var value2 = l2 == null
        ? 0
        : l2.val;

    final var sum = value1 + value2 + remainder;

    final var node = new ListNode(sum % 10);

    node.next = addTwoNumbers(l1 == null ? null : l1.next, l2 == null ? null : l2.next, sum / 10);

    return node;
  }


  public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }
}
