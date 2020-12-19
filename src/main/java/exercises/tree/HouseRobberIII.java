package exercises.tree;

import exercises.array.helper.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HouseRobberIII {
    public int rob(TreeNode root) {
        if (Objects.isNull(root) ) {
            return 0;
        } else {
            Map<Integer, Integer> map = rob( root, 0,  new HashMap<>(  ) );
            int[] result = new int[map.size() + 1];
            result[0] = 0;
            result[1] = map.get( 0 );

            for (int i = 2; i < result.length; i++) {
                int value = map.get( i - 1 );
                result[i] = Math.max( result[i-2] + value, value );
            }

            return result[map.size()];
        }
    }

    private Map<Integer, Integer> rob(TreeNode root,
                                      int level,
                                      Map<Integer, Integer> result) {
        if (Objects.isNull( root )) {
            return result;
        } else {
            result.put( level, result.getOrDefault( level, 0 ) + root.val );

            rob( root.left, level + 1, result );
            return rob( root.right, level + 1, result );
        }
    }
}
