package exercises.array;

import java.util.LinkedList;

public class RemoveDupes {
  public int removeDuplicates(final int[] nums) {
    var count = 1;
    var prevNum = nums[0];
    var index = 1;
    var elements = 1;

    for (int i = 1; i < nums.length; i++) {
      final var num = nums[i];
      if (prevNum == num) {
        if (count < 2) {
          nums[index] = num;
          count++;
          index++;
          elements++;
        }
      } else {
        nums[index] = num;
        prevNum = num;
        index++;
        elements++;
        count = 1;
      }
    }

    return elements;
  }
}
