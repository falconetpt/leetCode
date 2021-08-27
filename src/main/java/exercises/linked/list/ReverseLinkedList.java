package exercises.linked.list;

import java.util.LinkedList;
import java.util.Stack;

public class ReverseLinkedList {
  public ListNode reverseList(ListNode head) {
    final var reversedOrder = reverseList( head, new Stack<>(  ) );

    if (reversedOrder.empty()) {
      return null;
    } else {
      final var root = reversedOrder.pop();
      var next = root;

      while (!reversedOrder.empty()) {
        final var element = reversedOrder.pop();
        next.next = element;
        next = element;
        element.next = null;
      }

      return root;
    }
  }

  private Stack<ListNode> reverseList(ListNode head, Stack<ListNode> listNodes) {
    if (head == null) {
      return listNodes;
    } else {
      listNodes.push( head );
      return reverseList( head.next, listNodes );
    }
  }
}
