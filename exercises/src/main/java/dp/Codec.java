package dp;

import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Codec {

  public String serialize(TreeNode root) {
    if (root == null) return "";
    var str = String.valueOf(root.val);

    if (root.left != null || root.right != null) {
      str += "," + Optional.ofNullable(root.left).map(r -> String.valueOf(r.val)).orElse("X")
          + "," + Optional.ofNullable(root.right).map(r -> String.valueOf(r.val)).orElse("X");

      final var left = serialize(root.left);
      final var right = serialize(root.right);

      return Stream.of(str, left, right).filter(Objects::nonNull).collect(Collectors.joining("\n"));
    } else {
      return str;
    }
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if(data.trim().isEmpty()) return null;
    final var lineSplit = data.split("\n+");
    TreeNode root = null;
    final var map = new HashMap<Integer, TreeNode>();

    System.out.println("data = " + data);


    for (final var line : lineSplit) {
      final var origin = line.split(",");
      final var originValue = Integer.valueOf(origin[0]);

      if (root == null) {
        root = new TreeNode(originValue);
        map.put(originValue, root);
      }

      final var node = map.get(originValue);

      if (origin.length > 1) {
        final var left = origin[1].equals("X")
            ? null
            : Integer.parseInt(origin[1]);
        final var right = origin[2].equals("X")
            ? null
            : Integer.parseInt(origin[2]);

        System.out.println(line);

        map.put(left, left == null ? null : new TreeNode(left));
        map.put(right, right == null ? null : new TreeNode(right));

        node.left = map.get(left);
        node.right = map.get(right);
      }
    }

    return root;
  }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
