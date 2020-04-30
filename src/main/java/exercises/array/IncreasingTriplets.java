package exercises.array;

public class IncreasingTriplets {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null && nums.length < 3) {
            return false;
        } else {
            int num1 = Integer.MAX_VALUE;
            int num2 = Integer.MAX_VALUE;

            for (int i = 0, n = nums.length; i < n; i++) {
                if (nums[i] > num2) return true;
                if (nums[i] > num1) num2 = nums[i];
                if (nums[i] < num1) num1 = nums[i];
            }

            return false;
        }
    }
}
