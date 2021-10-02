package exercises.linked.list;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class OddEvenList {
  public ListNode oddEvenList(final ListNode head) {
    final var orderedNodes = oddEvenList(head, 1, new HashMap<>());
    if (orderedNodes.keySet().size() < 2) return head;
    final var root = orderedNodes.get(1).pollFirst();

    constructLink(orderedNodes, 1, root);

    return root;
  }

  private void constructLink(final Map<Integer, LinkedList<ListNode>> orderedNodes, final int i, final ListNode prev) {
    final var key = i % 2;
    final var nodes = orderedNodes.get(key);

    if (!nodes.isEmpty()) {
      final var element = nodes.pollFirst();

      prev.next = element;
      constructLink(orderedNodes, i, element);
    } else {
      if(i == 2 ) {
        prev.next = null;
      } else {
        constructLink(orderedNodes, i + 1, prev);
      }
    }
  }

  private Map<Integer, LinkedList<ListNode>> oddEvenList(final ListNode head,
                                                         final int i,
                                                         final HashMap<Integer, LinkedList<ListNode>> map) {
    if (head == null) {
      return map;
    } else {
      final var key = i % 2;
      map.putIfAbsent(key, new LinkedList<>());
      map.get(key).addLast(head);
      return oddEvenList(head.next, i + 1, map);
    }
  }
}
