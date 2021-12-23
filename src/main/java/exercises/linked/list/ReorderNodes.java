package exercises.linked.list;

import java.util.LinkedList;

public class ReorderNodes {
  public void reorderList(final ListNode head) {
    final var list = reorderList(head, new LinkedList<>());
    var node = list.pollFirst();
    var first = false;

    while (!list.isEmpty()) {
      node.next = first
        ? list.pollFirst()
        : list.pollLast();

      node = node.next;
      first = !first;
    }
    node.next = null;
  }

  private LinkedList<ListNode> reorderList(final ListNode head, final LinkedList<ListNode> listNodes) {
    if (head == null) {
      return listNodes;
    } else {
      listNodes.addLast(head);
      return reorderList(head.next, listNodes);
    }
  }
}
