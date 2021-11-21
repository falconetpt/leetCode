package exercises.blind;

public class DistinctNumber {
  public int singleNonDuplicate(int[] nums) {
    for(int i = 1; i < nums.length; i++) {
      if (nums[i] != nums[i-1]) return nums[i];
    }

    return -1;
  }
}
