package exercises.array;

import java.util.Arrays;

public class CountQuadruplets {
  public int countQuadruplets(final int[] nums) {
    int count  = 0;
    for (int i = 0 ; i < nums.length - 3; i++) {
      for(int j = i + 1; j < nums.length -2; j++) {
        for(int k = j + 1; k < nums.length - 1; k++){
          int sum = nums[i] + nums[j] + nums[k];
          for(int l =  k + 1; l < nums.length; l++){
            if(nums[l] == sum){
              count++;

            }
          }
        }
      }
    }
    return count;
  }
}
