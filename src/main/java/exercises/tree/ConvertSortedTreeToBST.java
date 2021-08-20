package exercises.tree;

import exercises.array.helper.TreeNode;

public class ConvertSortedTreeToBST {
  public TreeNode sortedArrayToBST(final int[] nums) {
    return sortedArrayToBST(nums, 0, nums.length);
  }

  private TreeNode sortedArrayToBST(final int[] nums,
                                final int start,
                                final int end) {
    if (start < end) {
      final var middle = (start + end) / 2;
      final var value = nums[middle];
      final var node = new TreeNode(value);
      node.left = sortedArrayToBST(nums, start, middle);
      node.right = sortedArrayToBST(nums, middle + 1, end);
      return node;
    } else {
      return null;
    }
  }
}
