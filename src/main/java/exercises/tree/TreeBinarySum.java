package exercises.tree;

import exercises.array.helper.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class TreeBinarySum {
    public int sumRootToLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            List<String> result = new ArrayList<>(  );
            constructList( root, "", result );

            return result.stream()
                    .map( s -> convertBinaryToInt( s, 0 ) )
                    .reduce( 0, Integer::sum );
        }
    }

    private void constructList(TreeNode root, String acc, List<String> result) {
        if (root != null) {
            String newStr = acc + root.val;

            if (Stream.of(root.left, root.right).allMatch( Objects::isNull )) {
                result.add( newStr );
            } else {
                constructList( root.left, newStr,  result);
                constructList( root.right,  newStr, result);
            }
        }
    }

    private int convertBinaryToInt(String binary, int index) {
        if (index >= binary.length()) {
            return 0;
        } else {
            int bin = binary.charAt(index) == '1' ? 1 : 0;
            return (int) Math.pow( 2, binary.length() - index - 1 ) * bin  + convertBinaryToInt(binary, index + 1);
        }
    }
}
