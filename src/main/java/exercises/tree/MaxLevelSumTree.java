package exercises.tree;

import exercises.array.array.helper.TreeNode;

import java.util.HashMap;

public class MaxLevelSumTree {
    public int maxLevelSum(final TreeNode root) {
        final var map = new HashMap<Integer, Integer>();
        traverseRoot(root, map, 0);

        var max = Integer.MIN_VALUE;
        var level = 0;

        for (final var entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                level = entry.getKey();
            }
        }

        return level;
    }

    private void traverseRoot(final TreeNode root,
                              final HashMap<Integer, Integer> map,
                              final int level) {
        if (root != null) {
            map.put(level, map.getOrDefault(level, 0 + root.val));
            traverseRoot(root.left, map, level + 1);
            traverseRoot(root.right, map, level + 1);
        }
    }
}