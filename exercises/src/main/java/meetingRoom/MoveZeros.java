package meetingRoom;

import java.util.LinkedList;

public class MoveZeros {
  public void moveZeroes(int[] nums) {
    final var linkedList = getOrderedList(nums);

    for (int i = 0; i < nums.length; i++) {
      nums[i] = linkedList.isEmpty()
          ? 0
          : linkedList.poll();
    }
  }

  private LinkedList<Integer> getOrderedList(int[] nums) {
    final var result = new LinkedList<Integer>();

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) result.add(nums[i]);
    }

    return result;
  }
}
