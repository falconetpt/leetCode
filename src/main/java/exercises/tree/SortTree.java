package exercises.tree;

import exercises.linked.list.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortTree {
    public ListNode sortList(ListNode head) {
        List<ListNode> nodes = getNodes(head, new ArrayList<>())
                .stream()
                .sorted( Comparator.comparingInt( a -> a.val ) )
                .collect( Collectors.toList());

        nodes.stream().reduce( (a, b) -> {
            a.next = b;
            b.next = null;
            return b;
        } );


        return nodes.stream()
                .findFirst()
                .orElse( null );
    }

    private List<ListNode> getNodes(ListNode head, ArrayList<ListNode> listNodes) {
        if (head == null) {
            return listNodes;
        } else {
            listNodes.add( head );
            return getNodes( head.next, listNodes );
        }
    }
}
