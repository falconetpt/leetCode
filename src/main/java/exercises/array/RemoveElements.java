package exercises.array;

import exercises.linked.list.ListNode;

public class RemoveElements {
  public ListNode removeElements(final ListNode head,
                                 final int val) {
    if (head == null) {
      return null;
    } else {
      if (head.val == val) {
        return removeElements(head.next, val);
      }

      head.next = removeElements(head.next, val);

      return head;
    }
  }
}
