package exercises.blind;

import exercises.linked.list.ListNode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Objects;
import java.util.PriorityQueue;

public class MergeKList {
  public ListNode mergeKLists(final ListNode[] lists) {
    final var queue = new PriorityQueue<ListNode>(Comparator.comparing(l -> l.val));
    Arrays.stream(lists)
      .filter(Objects::nonNull)
      .forEach(queue::add);

    if (queue.isEmpty()) return null;
    final var element = queue.poll();
    final var result = new ListNode(element.val);
    var prev = result;
    if (element.next != null) queue.add(element.next);

    while (!queue.isEmpty()) {
      final var next = queue.poll();

      prev.next = new ListNode(next.val);
      if (next.next != null) queue.add(next.next);
      prev = prev.next;
    }

    return result;
  }
}
