package exercises.array;

import exercises.linked.list.ListNode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKLists {
  public ListNode mergeKLists(final ListNode[] lists) {
    if (lists.length == 0) return null;
    final var prioQueue = new PriorityQueue<ListNode>(Comparator.comparing(l -> l.val));

    Arrays.stream(lists)
      .forEach(l -> addToQueue(l, prioQueue));

    final var first = prioQueue.isEmpty()
      ? null
      : prioQueue.poll();
    var current = first;

    while (!prioQueue.isEmpty()) {
      final var next = prioQueue.poll();
      current.next = next;
      current = next;
    }

    if(current != null) current.next = null;

    return first;
  }

  private void addToQueue(final ListNode node, final PriorityQueue<ListNode> prioQueue) {
    if (node != null) {
      prioQueue.add(node);
      addToQueue(node.next, prioQueue);
    }
  }
}
