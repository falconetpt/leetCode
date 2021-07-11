package exercises.array.array;

import exercises.linked.list.ListNode;

import java.util.PriorityQueue;

public class SortLinkedList {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        } else  {
            PriorityQueue<Integer> sortLinkedLists = sortList( head, new PriorityQueue<Integer>(  ) );
            ListNode result = new ListNode(sortLinkedLists.poll());
            createResult(sortLinkedLists, result);
            return result;
        }
    }

    private void createResult(PriorityQueue<Integer> sortLinkedLists, ListNode node) {
        if (!sortLinkedLists.isEmpty()) {
            ListNode nextNode = new ListNode( sortLinkedLists.poll() );
            node.next = nextNode;
            createResult( sortLinkedLists, nextNode );
        }
    }

    private PriorityQueue<Integer> sortList(ListNode head, PriorityQueue<Integer> integers) {
        if (head == null) {
            return integers;
        } else {
            integers.add( head.val );
            return sortList( head.next, integers );
        }
    }
}
