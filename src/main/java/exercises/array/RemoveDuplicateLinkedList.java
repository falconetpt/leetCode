package exercises.array;

import exercises.linked.list.ListNode;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class RemoveDuplicateLinkedList {
  public ListNode deleteDuplicates(final ListNode head) {
    final var removeNodes = new LinkedHashMap<Integer, Boolean>();
    fillMap(head, removeNodes);

    return deleteDuplicates(head, removeNodes);
  }

  private ListNode deleteDuplicates(final ListNode head, final LinkedHashMap<Integer, Boolean> removeNodes) {
    if (head == null) {
      return null;
    } else {
      if (removeNodes.get(head.val)) {
        return deleteDuplicates(head.next, removeNodes);
      } else {
        head.next = deleteDuplicates(head.next, removeNodes);
        return head;
      }
    }
  }

  private void fillMap(final ListNode head, final LinkedHashMap<Integer, Boolean> removeNodes) {
    if (head != null) {
      if (removeNodes.containsKey(head.val)) {
        removeNodes.put(head.val, true);
      } else {
        removeNodes.put(head.val, false);
      }

      fillMap(head.next, removeNodes);
    }
  }
}
