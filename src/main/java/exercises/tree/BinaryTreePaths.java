package exercises.tree;

import exercises.array.helper.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
  public List<String> binaryTreePaths(TreeNode root) {
    return binaryTreePaths( root, new ArrayList<String>(), new ArrayList<String>(  ) );
  }

  private List<String> binaryTreePaths(final TreeNode root,
                                       final List<String> strings,
                                       final List<String> result) {
    if (root == null) {
      return result;
    } else {
      strings.add(String.valueOf(root.val));

      if (root.left == null && root.right == null) {
        result.add( String.join( "->" , strings) );
      } else {
        binaryTreePaths( root.right, new ArrayList<>( strings ), result );
        binaryTreePaths( root.left, new ArrayList<>( strings ), result );
      }

      return result;
    }
  }
}
