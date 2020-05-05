package exercises.tree;

import exercises.array.helper.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class MaxLevelSum {
    public int maxLevelSum(TreeNode root) {
        Map<Integer, Integer> result = new HashMap<>(  );
        maxLevelSum( root, 1, result );
        return result.keySet().stream()
                .reduce( 0, (a, b) -> result.getOrDefault( a, 0 ) > result.getOrDefault( b, 0 ) ? a : b );
    }

    private void maxLevelSum(TreeNode root, int level, Map<Integer, Integer> cache) {
        if (root != null) {
            int result = root.val + cache.getOrDefault( level, 0 );
            cache.put( level, result );

            maxLevelSum( root.left, level + 1, cache );
            maxLevelSum( root.right, level + 1, cache );
        }
    }
}
