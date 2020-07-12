package exercises.tree;

import exercises.array.helper.TreeNode;

import java.util.*;

public class MaxWidth {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return widthOfBinaryTree( root, 0, 0, new HashMap<>(  ) );
        }
    }

    private int widthOfBinaryTree(TreeNode node,
                                  int level,
                                  int position,
                                  Map<Integer, List<Integer>> map) {
        if (node == null) {
            return map.values().stream()
                    .map( a -> a.stream().max( Integer::compareTo ).get() - a.stream().min( Integer::compareTo ).get() + 1)
                    .max( Integer::compareTo)
                    .orElse( 0 );
        } else {
            map.putIfAbsent( level, new ArrayList<>(  ) );
            map.get( level ).add( position );
            int baseLevel = 2 * position;

            widthOfBinaryTree( node.left, level + 1, baseLevel, map );
            return widthOfBinaryTree( node.right, level + 1, baseLevel + 1, map );
        }
    }
}
