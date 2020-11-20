package exercises.array;

import java.util.stream.IntStream;

public class SearchInRotatedArray {
    public boolean search(int[] nums, int target) {
        int pivot = IntStream.range( 1, nums.length )
                .filter( i -> nums[i] < nums[i-1] )
                .limit( 1 )
                .findFirst()
                .orElse( 0 );

        return search( nums, 0, nums.length - 1, target, pivot );
    }

    private boolean search(int[] nums, int start, int end, int target, int pivot) {
        if (start > end) {
            return false;
        } else {
            int position = (start + end + pivot) / 2 % nums.length;

            if (nums[position] == target) return true;

            return nums[position] > target
                    ? search( nums, start + 1, position, target, pivot )
                    : search( nums, position, end, target, pivot );
        }
    }
}
