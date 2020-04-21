package exercises.trees;

import exercises.array.helper.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SumNumbers {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            List<Integer> list = new ArrayList<>(  );
            sumNumbers( root, "",  list);
            return list.stream().reduce( 0, Integer::sum );
        }
    }

    public List<Integer> sumNumbers(final TreeNode root, final String num, final List<Integer> result) {
        if (root.getRight() == null && root.getLeft() == null) {
            String value = num + root.val;
            result.add( Integer.valueOf( value ) );

            return result;
        } else {
            if (root.getLeft() != null) sumNumbers( root.getLeft(), num + root.val, result );
            if (root.getRight() != null) sumNumbers( root.getRight(), num + root.val, result );

            return result;
        }
    }

}
