package exercises.tree;

import exercises.array.helper.TreeNode;

import java.util.*;
import java.util.stream.IntStream;

public class CompleteTree {
    public boolean isCompleteTree(final TreeNode root) {
        final Map<Integer, Integer[]> levels = new HashMap<>(  );
        fillMap(root, levels, 0, 0);
        return isCompleteTree( levels, levels.keySet().size(), 0 );
    }

    private boolean isCompleteTree(Map<Integer, Integer[]> levels, int size, int i) {
        if (i >= size) {
            return true;
        } else {
            if (i == size - 1) {
                Integer[] values = levels.get( i );
                int maxInLevel = (int) Math.pow( 2, i );
                Optional<Integer> firstNull = IntStream.range( 0, maxInLevel ).boxed()
                        .filter( x -> Objects.isNull( values[x] ) )
                        .findFirst();

                return firstNull
                        .map( x -> IntStream.range(x, maxInLevel ).boxed().noneMatch( y -> Objects.nonNull( values[y] ) ) )
                        .orElse( true );
            } else {
                boolean valid = Arrays.stream(levels.get( i ))
                        .allMatch( Objects::nonNull );
                return valid & isCompleteTree( levels, size, i + 1 );
            }
        }
    }

    private void fillMap(final TreeNode root,
                         final Map<Integer, Integer[]> levels,
                         final int level,
                         final int index) {
        if (Objects.nonNull(root)) {
            levels.putIfAbsent( level, new Integer[(int) Math.pow( 2, level )] );
            levels.get( level )[index] = root.val;
            fillMap( root.left, levels, level + 1, index * 2 );
            fillMap( root.right, levels, level + 1, index * 2 + 1 );
        }
    }
}
