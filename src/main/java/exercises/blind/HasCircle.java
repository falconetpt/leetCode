package exercises.blind;

import exercises.linked.list.ListNode;

import java.util.HashSet;
import java.util.Set;

public class HasCircle {
  public boolean hasCycle(final ListNode head) {
    return hasCycle(head, new HashSet<>());
  }

  private boolean hasCycle(final ListNode head, final Set<ListNode> listNodes) {
    if(head == null) {
      return false;
    } else if (listNodes.contains(head)) {
      return true;
    } else {
      listNodes.add(head);
      return hasCycle(head.next, listNodes);
    }
  }
}
