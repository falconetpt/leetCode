package exercises.array;

import java.util.stream.IntStream;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        if(nums != null && nums.length > 1 && k % nums.length != 0) {
            int toRotate = k % nums.length;
            int[] result = generateResult(nums, nums.length - toRotate, new int[nums.length], nums.length, 0);
            IntStream.range( 0, nums.length )
                    .forEach( i -> nums[i] = result[i] );
        }
    }

    private int[] generateResult(int[] nums, int i, int[] result, int length, int index) {
        if (length == 0) {
            return result;
        } else {
            System.out.println("length" + length);
            System.out.println(index + " : " + i);
            result[index] = nums[i];
            return generateResult( nums, (i + 1) % nums.length, result, length - 1, index + 1 );
        }
    }
}
