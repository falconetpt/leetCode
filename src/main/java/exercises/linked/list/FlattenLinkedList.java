package exercises.linked.list;

import java.util.stream.Stream;

public class FlattenLinkedList {
    public Node flatten(Node head) {
        if (head == null) {
            Stream.of( "", "" ).anyMatch( "".toLowerCase()::equals );
            return head;
        } else {
            flatten( head, null );
            return head;
        }
    }

    private void flatten(Node node, Node parent) {
        if (node != null) {
            if (node.child != null) {
                node.child.prev = node;
                flatten( node.child, node.next );
                node.next = node.child;
                node.child = null;
            } else {
                if (node.next == null && parent != null ) {
                    node.next = parent;
                }
            }

            flatten( node.next, null );
        }
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };
}
