package exercises.linked.list;

import java.util.Optional;

public class SwapNode {
    public ListNode swapPairs(final ListNode head) {
        return swapPairs(head, head);
    }

    private ListNode swapPairs(ListNode node, ListNode head) {
        if (node == null) {
            return head;
        } else {

            int nextVal = Optional.ofNullable(node.next)
                    .map(x -> x.val)
                    .orElse(node.val);
            int val = node.val;


            Optional.ofNullable(node.next).ifPresent(x -> x.val = val);
            node.val = nextVal;


            return swapPairs(Optional.ofNullable(node.next).map(x -> x.next).orElse(null), head);
        }
    }
}
