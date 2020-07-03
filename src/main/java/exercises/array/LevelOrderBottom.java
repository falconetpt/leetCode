package exercises.array;

import exercises.array.helper.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LevelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Map<Integer, List<Integer>> result = levelOrderBottom(root, 0, new HashMap<>(  ) );
        return IntStream.range( 0, result.size() )
                .boxed()
                .sorted( (a, b) -> -a.compareTo( b ) )
                .map( result::get )
                .collect( Collectors.toList() );
    }

    public Map<Integer, List<Integer>> levelOrderBottom(TreeNode root, int level, Map<Integer, List<Integer>> result) {
        if (root == null) {
            return result;
        } else {
            result.putIfAbsent( level, new ArrayList<>(  ) );
            result.get( level ).add( root.val );

            levelOrderBottom( root.left, level + 1, result );
            return levelOrderBottom( root.right, level + 1, result );
        }
    }
}
