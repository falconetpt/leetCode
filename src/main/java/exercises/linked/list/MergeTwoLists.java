package exercises.linked.list;

public class MergeTwoLists {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    final var listNode = new ListNode();

    if (l1 == null && l2 == null) return null;
    if (l1 == null) return l2;
    if (l2 == null) return l1;

    if (l1.val > l2.val) {
      listNode.val = l2.val;
      return mergeTwoLists(l1, l2.next, listNode, listNode);
    } else {
      listNode.val = l1.val;
      return mergeTwoLists(l1.next, l2, listNode, listNode);
    }
  }

  private ListNode mergeTwoLists(final ListNode l1, final ListNode l2, final ListNode next, final ListNode root) {
    if (l1 == null && l2 == null) {
      return root;
    } else if (l1 == null) {
      final var listNode = new ListNode();
      listNode.val = l2.val;
      next.next = listNode;
      return mergeTwoLists(l1, l2.next, listNode, root);
    } else if (l2 == null) {
      final var listNode = new ListNode();
      listNode.val = l1.val;
      next.next = listNode;
      return mergeTwoLists(l1.next, l2, listNode, root);
    } else {
      final var listNode = new ListNode();
      if (l1.val > l2.val) {
        listNode.val = l2.val;
        next.next = listNode;
        return mergeTwoLists(l1, l2.next, listNode, root);
      } else {
        listNode.val = l1.val;
        next.next = listNode;
        return mergeTwoLists(l1.next, l2, listNode, root);
      }
    }
  }
}
