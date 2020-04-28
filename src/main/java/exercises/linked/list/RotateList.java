package exercises.linked.list;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        int size = getSize(head);
        int indexFromEnd = k % size;

        if(indexFromEnd == 0 || indexFromEnd > size) {
            return head;
        }

        ListNode newHead = getElementAt(head, size - indexFromEnd, 0);
        ListNode tmp = newHead.next;
        ListNode result = tmp;

        while (tmp.next != null) {
            result = result.next;
        }

        result.next = head;
        newHead.next = null;

        return tmp;
    }

    private ListNode getElementAt(ListNode node, int target, int index) {
        if (index == target) {
            return node;
        } else {
            return getElementAt( node.next, target, index + 1 );
        }
    }

    private int getSize(ListNode node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + getSize( node.next );
        }
    }
}
