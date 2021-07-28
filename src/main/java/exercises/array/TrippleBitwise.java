package exercises.array;

public class TrippleBitwise {
  public int countTriplets(int[] nums) {
    var result = 0;

    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < nums.length; j++) {
        for (int k = 0; k < nums.length; k++) {
          if ((nums[i] & nums[j] & nums[k]) == 0) result++;
        }
      }
    }

    return result;
  }
}
