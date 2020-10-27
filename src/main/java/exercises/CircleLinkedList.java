package exercises;

import exercises.linked.list.ListNode;

import java.util.HashSet;
import java.util.Set;

public class CircleLinkedList {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        } else {
            return detectCycle( head, new HashSet<>(  ) );
        }
    }

    private ListNode detectCycle(ListNode head, Set<ListNode> set) {
        if (head == null) {
            return null;
        } else {
            if (set.contains( head )) return head;
            set.add( head );

            return detectCycle( head.next, set );
        }
    }
}
