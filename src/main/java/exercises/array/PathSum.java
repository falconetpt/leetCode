package exercises.array;

import exercises.array.helper.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        return new ArrayList<>( pathSum( root, 0, sum, new ArrayList<>(  ), new HashSet<>(  ) ));
    }

    private Set<List<Integer>> pathSum(TreeNode root,
                                       int currentSum,
                                       int sum,
                                       List<Integer> localResult,
                                       Set<List<Integer>> result) {
        if (root == null) {
            if (currentSum == sum) result.add( localResult );
            return result;
        } else {
            int value = root.val + currentSum;
            localResult.add( root.val );

            if (value >= sum) {
                return result;
            } else {
                pathSum( root.left, value, sum, new ArrayList<>( localResult ), result );
                pathSum( root.right, value, sum, new ArrayList<>( localResult ), result );

                return result;
            }
        }
    }
}
