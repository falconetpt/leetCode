package exercises.array;

import exercises.linked.list.ListNode;

import java.util.LinkedList;

public class OddThenEven {
  public ListNode oddEvenList(final ListNode head) {
    if (head == null) return null;
    final var root = head;
    final var odd = new LinkedList<ListNode>();
    final var even = new LinkedList<ListNode>();
    fillNodes(head, odd, even);
    odd.addAll(even);

    var prev = odd.poll();

    while (!odd.isEmpty()) {
      final var next = odd.poll();
      prev.next = next;
      prev = next;
    }
    prev.next = null;

    return head;
  }

  private void fillNodes(final ListNode head, final LinkedList<ListNode> odd, final LinkedList<ListNode> even) {
    if (head != null) {
      odd.add(head);
      fillNodes(head.next, even, odd);
    }
  }
}
