package exercises.linked.list;

import java.util.Objects;
import java.util.Optional;

public class RemoveNode {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        } else {
            removeElements( head, head.next, val );
            return head;
        }
    }

    private void removeElements(ListNode node, ListNode next, int val) {
        if (Objects.nonNull(node)) {
            if (node.next.val == val) {
                node.next.next = node.next;
            }

            Optional.ofNullable(node.next).ifPresent( n ->  removeElements(n, n.next, val ));
        }
    }
}
