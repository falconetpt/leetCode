package exercises.linked.list;

import java.util.Optional;

public class RemoveElement {
    public void deleteNode(ListNode node) {
        if (node != null) {
            node.val = Optional.ofNullable(node.next).map( x -> x.val ).orElse( null );
            node.next = Optional.ofNullable(node.next).map( x -> x.next ).orElse( null )
        }
    }
}
