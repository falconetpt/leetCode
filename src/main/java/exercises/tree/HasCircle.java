package exercises.tree;

import exercises.linked.list.ListNode;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class HasCircle {
    public boolean hasCycle(ListNode head) {
        return hasCycle( head, new HashSet<>(  ) );
    }

    private boolean hasCycle(ListNode head, Set<ListNode> seen) {
        if (Objects.isNull(head)) {
            return false;
        } else {
            if (seen.contains( head )) {
                return true;
            } else {
                seen.add( head );
                return hasCycle( head.next, seen );
            }
        }
    }

}
