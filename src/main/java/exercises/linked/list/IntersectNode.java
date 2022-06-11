package exercises.linked.list;

import java.util.HashSet;
import java.util.Set;

public class IntersectNode {
  public ListNode getIntersectionNode(final ListNode headA, final ListNode headB) {
    final var seen = new HashSet<ListNode>();
    fillNode(headA, seen);

    return getIntersectionNode(headB, seen);
  }

  public ListNode getIntersectionNode(final ListNode head, final Set<ListNode> seen) {
    if (head == null) {
      return null;
    } else if (seen.contains(head)) {
      return head;
    } else {
      return getIntersectionNode(head.next, seen);
    }
  }

  private void fillNode(final ListNode head, final Set<ListNode> seen) {
    if (head != null) {
      seen.add(head);
      fillNode(head.next, seen);
    }
  }
}
