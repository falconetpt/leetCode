package exercises.tree;

import exercises.array.helper.TreeNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LargestValue {
    public List<Integer> largestValues(TreeNode root) {
        Map<Integer, Integer> result = new HashMap<>();
        largestValues(root, result, 0);
        return IntStream.range(0, result.keySet().size()).boxed()
                .map( result::get ).collect( Collectors.toList() );
    }

    public void largestValues(TreeNode root, Map<Integer, Integer> result, int level) {
        if(root != null) {
            result.put(level, Math.max(result.getOrDefault(level, Integer.MIN_VALUE), root.val));
            largestValues(root.left, result, level + 1);
            largestValues(root.right, result, level + 1);
        }
    }
}
