package dp;
import dp.SumLinkedNode.ListNode;

public class AddTwoLinkedList {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    return joiningList(l1, l2, 0);
  }

  public ListNode joiningList(ListNode l1, ListNode l2,  int previousRemainder) {
    if(l1 == null && l2 == null) return previousRemainder == 0
        ? null
        : new ListNode(previousRemainder);

    final var l1Value = l1 == null ? 0 : l1.val;
    final var l2Value = l2 == null ? 0 : l2.val;
    final var finalSum = l1Value + l2Value + previousRemainder;
    final var result = new ListNode(finalSum % 10);
    final var nextRemainder = finalSum / 10;

    result.next = joiningList(l1 == null ? null : l1.next, l2 == null ? null : l2.next, nextRemainder);

    return result;
  }
}
