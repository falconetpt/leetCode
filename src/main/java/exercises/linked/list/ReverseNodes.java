package exercises.linked.list;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseNodes {
  public ListNode reverseKGroup(ListNode head, int k) {
    final var nodes = new LinkedList<ListNode>();

    return reverseKGroup(null, head, k, nodes);
  }

  private ListNode reverseKGroup(final ListNode head,
                                 final ListNode next,
                                 final int k,
                                 final LinkedList<ListNode> nodes) {
    if (nodes.size() == k) {
      return swapNodes(nodes, k);
    } else if (next != null) {
      nodes.addLast(next);
      return reverseKGroup(head, next.next, k, nodes);
    }

    return next;
  }

  private ListNode swapNodes(final LinkedList<ListNode> nodes, final int k) {
    final var node = nodes.pollLast();
    final var nextNodeStatic = node.next;
    var pivot = node;

    while (!nodes.isEmpty()) {
      final var nextNode = nodes.pollLast();
      System.out.println(nextNode.val);
      pivot.next = nextNode;
      pivot = nextNode;
    }

    final var reversed = reverseKGroup(nextNodeStatic, nextNodeStatic, k, nodes);

    pivot.next = reversed == null
      ? nextNodeStatic
      : reversed;

    return node;
  }


}
