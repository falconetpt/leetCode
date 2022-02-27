package exercises.sort;

import exercises.linked.list.ListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SortList {
  public ListNode sortList(final ListNode head) {
    final var priorityQueue = buildPrioQueue(head);

    if (priorityQueue.isEmpty()) return null;

    final var top = priorityQueue.poll();
    var prev = top;

    while (!priorityQueue.isEmpty()) {
      prev.next = priorityQueue.poll();
      prev = prev.next;
    }

    prev.next = null;

    return top;
  }

  private PriorityQueue<ListNode> buildPrioQueue(final ListNode head) {
    final var priorityQueue = new PriorityQueue<ListNode>(Comparator.comparing(p -> p.val));
    return buildPrioQueue(head, priorityQueue);
  }

  private PriorityQueue<ListNode> buildPrioQueue(final ListNode head,
                                                 final PriorityQueue<ListNode> priorityQueue) {
    if (head == null) {
      return priorityQueue;
    } else {
      priorityQueue.add(head);
      return buildPrioQueue(head.next, priorityQueue);
    }
  }
}
