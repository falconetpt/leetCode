package exercises.array;

public class FindPeek {
    public int findPeakElement(int[] nums) {
        if(nums.length <= 1) return 0;
        return findPeakElement( nums, 1 );
    }

    private int findPeakElement(int[] nums, int i) {
        if (i >= nums.length - 1) {
            return nums[i] > nums[i-1] ? i : 0;
        } else {
            if (nums[i] > nums[i-1] && nums[i] > nums[i+1]) {
                return i;
            } else {
                return findPeakElement( nums, i + 1 );
            }
        }
    }
}
