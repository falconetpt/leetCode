package exercises.sort;

import exercises.linked.list.ListNode;

public class MergeSortLinkedList {
  public ListNode mergeTwoLists(final ListNode list1, final ListNode list2) {
    if (list1 == null) return list2;
    if (list2 == null) return list1;

    if (list1.val < list2.val) {
      list1.next = mergeTwoLists(list1.next, list2);
      return list1;
    } else {
      list2.next = mergeTwoLists(list1, list2.next);
      return list2;
    }
  }
}
