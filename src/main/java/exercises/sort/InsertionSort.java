package exercises.sort;

import exercises.linked.list.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class InsertionSort {
  public ListNode insertionSortList(final ListNode head) {
    var result = constructList(head, new LinkedList<>())
      .stream()
      .sorted(Comparator.comparing(h -> h.val))
      .collect(Collectors.toCollection(LinkedList::new));

    final var root = result.pollFirst();
    var base = root;

    while (!result.isEmpty()) {
      final var next = result.pollFirst();
      base.next = next;
      base = next;
      next.next = null;
    }

    return root;
  }

  private LinkedList<ListNode> constructList(final ListNode head, final LinkedList<ListNode> objects) {
    if (head == null) {
      return objects;
    } else {
      objects.addLast(head);
      return constructList(head.next, objects);
    }
  }
}
