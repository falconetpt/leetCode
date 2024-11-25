package dp;

import java.util.Optional;

public class RemoveFromEnd {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    if (head.next == null || n == 1) return null;
    final var newHead = new ListNode(0);
    newHead.next = head;
    final var pivotNode = removeNthFromEnd(newHead, newHead, n);
    if (pivotNode != null) {
      pivotNode.next = pivotNode.next != null
          ? pivotNode.next.next
              : null;
    }

    return newHead.next;
  }

  private ListNode removeNthFromEnd(ListNode head, ListNode pivotNode, int n) {
    if (head == null) return pivotNode;
    var newPivotNode = pivotNode;
    if (n <= 0) {
      newPivotNode = pivotNode.next;
    }

    return removeNthFromEnd(head.next, newPivotNode, n - 1);
  }

  /**
   * Definition for singly-linked list.
   */
   public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
