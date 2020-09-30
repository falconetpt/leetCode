package exercises.array;

import java.util.Arrays;

public class MissingElement {
    public int firstMissingPositive(int[] nums) {
        boolean[] smallest = new boolean[nums.length];

        Arrays.stream(nums)
                .filter( n -> n > 0 )
                .filter( n -> n <= nums.length )
                .forEach( n -> smallest[n-1] = true );

        for (int i = 0; i < nums.length; i++) {
            if (!smallest[i]) {
                return i+1;
            }
        }

        return nums.length + 1;
    }
}
