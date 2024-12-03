package dp;
import dp.SumLinkedNode.ListNode;

public class MergeTwoLinkedLists {
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    if (list1 == null && list2 == null) return null;
    if (list1 == null) {
      final var node = new ListNode(list2.val);
      node.next = mergeTwoLists(list1, list2.next);

      return node;
    }

    if (list2 == null) {
      final var node = new ListNode(list1.val);
      node.next = mergeTwoLists(list1.next, list2);

      return node;
    }

    if (list1.val < list2.val) {
      final var node = new ListNode(list1.val);
      node.next = mergeTwoLists(list1.next, list2);

      return node;
    } else {
      final var node = new ListNode(list2.val);
      node.next = mergeTwoLists(list1, list2.next);

      return node;
    }
  }
}
