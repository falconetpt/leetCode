package exercises.tree;

import exercises.array.helper.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BinaryTreeSort {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> result = new ArrayList<>(  );

        Stream.of(root1, root2).forEach( r -> fillList( r, result ) );

        return result.stream()
                .sorted()
                .collect( Collectors.toList());
    }

    private void fillList(TreeNode node, List<Integer> result) {
        if (Objects.nonNull(node)) {
            result.add( node.val );
            fillList( node.left, result );
            fillList( node.right, result );
        }
    }
}
