package exercises.linked.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomLinkedList {
  private List<Integer> list;
  private Random random;

  public RandomLinkedList(final ListNode head) {
    list = createList(head, new ArrayList<>());
    random = new Random();
  }

  private List<Integer> createList(final ListNode head, final List<Integer> integers) {
    if (head == null) {
      return integers;
    } else {
      integers.add(head.val);
      return createList(head.next, integers);
    }
  }

  public int getRandom() {
    return list.get(random.nextInt(list.size()));
  }
}
