package dp;

import dp.SumLinkedNode.ListNode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

public class MergeKLists {
  public ListNode mergeKLists(ListNode[] lists) {
    final var priorityQueue = new PriorityQueue<ListNode>(Comparator.comparing(a -> a.val));
    Arrays.stream(lists).filter(Objects::nonNull)
        .forEach(priorityQueue::add);
    if(priorityQueue.isEmpty()) return null;
    final var first = priorityQueue.poll();
    var result = new ListNode(first.val);
    var point = result;

    if(first.next != null) priorityQueue.add(first.next);

    while (!priorityQueue.isEmpty()) {
      final var element = priorityQueue.poll();
      final var newNode = new ListNode(element.val);

      point.next = newNode;
      point = newNode;

      if(element.next != null) priorityQueue.add(element.next);
    }

    return result;
  }

}
