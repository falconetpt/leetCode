package exercises.array.array;

import java.util.stream.IntStream;

public class SubArrayProduct {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int result = 0;

        for (int i = 0, n = nums.length; i < n; i++) {
            int resultNumber = result;
            int multiply = 1;
            for (int j = i; j < n; j++) {
                multiply *= nums[j];

                if (multiply < k) {
                    result++;
                } else {
                    break;
                }
            }

            if (result == resultNumber + n - i) {
                result += IntStream.rangeClosed( 1, n - i).reduce( 1, (a, b) -> a * b );
                break;
            }
        }

        return result;
    }

    private int[] getRightProduct(int[] nums) {
        int[] result = new int[nums.length];
        int mult = 1;

        for (int i = 0; i < nums.length; i++) {
            mult *= nums[i];
            result[i] = mult;
        }

        return result;
    }

    private int[] getLeftProduct(int[] nums) {
        int[] result = new int[nums.length];
        int mult = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            mult *= nums[i];
            result[i] = mult;
        }

        return result;
    }
}
