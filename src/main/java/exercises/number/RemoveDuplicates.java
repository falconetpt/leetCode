package exercises.number;

import exercises.linked.list.ListNode;

public class RemoveDuplicates {
  public ListNode deleteDuplicates(final ListNode head) {
    if (head != null && head.next != null) {
      if (head.val == head.next.val) {
        head.next = head.next.next;
        deleteDuplicates(head);
      }

      deleteDuplicates(head.next);
    }

    return head;
  }
}
