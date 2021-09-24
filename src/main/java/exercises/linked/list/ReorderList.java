package exercises.linked.list;

import java.util.LinkedList;

public class ReorderList {
  public void reorderList(final ListNode head) {
    final var list = reorderList(head, new LinkedList<>());
    var first = true;

    while (!list.isEmpty()) {
      final var next = first
        ? list.pollFirst()
        : list.pollLast();
      System.out.println("next = " + next.val);
      if (list.isEmpty()) {
        next.next = null;
      } else {
        next.next = first
          ? list.peekLast()
          : list.peekFirst();
      }
      first = !first;
      System.out.println("list = " + list.size());
    }
  }

  private LinkedList<ListNode> reorderList(final ListNode head,
                                           final LinkedList<ListNode> listNodes) {
    if (head == null) {
      return listNodes;
    } else {
      listNodes.addLast(head);
      return reorderList(head.next, listNodes);
    }
  }
}
