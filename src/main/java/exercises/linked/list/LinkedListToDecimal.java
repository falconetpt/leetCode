package exercises.linked.list;

import java.util.LinkedList;

public class LinkedListToDecimal {
  public int getDecimalValue(ListNode head) {
    final var binaryList = getDecimalValue(head, new LinkedList<>());
    var count = 0;
    var result = 0;

    while (!binaryList.isEmpty()) {
      final var element = binaryList.pollLast();

      result += element * (int) Math.pow(2, count);
      count++;
    }

    return result;
  }

  private LinkedList<Integer> getDecimalValue(final ListNode head, final LinkedList<Integer> integers) {
    if (head == null) {
      return integers;
    } else {
      integers.add(head.val);
      return getDecimalValue(head.next, integers);
    }
  }
}
