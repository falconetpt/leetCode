package exercises.tree;

import exercises.array.helper.TreeNode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ZigZagTree {
    public List<List<Integer>> zigzagLevelOrder(final TreeNode root) {
        if (root == null) {
            return new ArrayList<>(  );
        } else {
            final Map<Integer,List<Integer>> map = new HashMap<>();
            zigzagLevelOrder(root, 1, map, 0);

            return IntStream.range( 0, map.size() ).boxed()
                    .map( map::get )
                    .collect( Collectors.toList() );
        }
    }

    private void zigzagLevelOrder(final TreeNode node,
                                  final int order,
                                  final Map<Integer,List<Integer>> map,
                                  final int level) {
        if (Objects.nonNull( node )) {
            map.putIfAbsent( level, new ArrayList<>(  ) );

            if (order == 1) {
                map.get( level ).add( node.val );
            } else {
                map.get( level ).add( 0,  node.val );
            }

            zigzagLevelOrder( node.left, order * -1, map, level + 1 );
            zigzagLevelOrder( node.right, order * -1, map, level + 1 );
        }
    }
}
