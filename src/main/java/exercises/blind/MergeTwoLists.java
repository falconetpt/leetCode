package exercises.blind;

import exercises.linked.list.ListNode;

public class MergeTwoLists {
  public ListNode mergeTwoLists(final ListNode l1, final ListNode l2) {
    if (l1 == null && l2 == null) return null;
    if (l1 == null) return l2;
    if (l2 == null) return l1;

    final var first = l1;
    final var second = l2;

    if (first.val > second.val) {
      final var root = new ListNode(second.val);
      root.next = mergeTwoLists(l1, l2.next);
      return root;
    } else {
      final var root = new ListNode(first.val);
      root.next = mergeTwoLists(l1.next, l2);
      return root;
    }
  }
}
