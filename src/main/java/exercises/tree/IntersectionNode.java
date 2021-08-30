package exercises.tree;

import exercises.linked.list.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IntersectionNode {
  public ListNode getIntersectionNode(final ListNode headA, final ListNode headB) {
    final var seen = new HashSet<ListNode>();

    return getIntersectionNode(headA, headB, seen);
  }

  private ListNode getIntersectionNode(final ListNode headA, final ListNode headB, final Set<ListNode> seen) {
    if (headA == null && headB == null) {
      return null;
    } else {
      if (headA != null && seen.contains(headA)) return headA;
      if (headA != null) seen.add(headA);
      if (headB != null && seen.contains(headB)) return headB;
      if (headB != null) seen.add(headB);

      return getIntersectionNode(headA == null ? null : headA.next, headB == null ? null : headB.next, seen);
    }
  }
}
