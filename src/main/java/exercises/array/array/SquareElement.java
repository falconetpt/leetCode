package exercises.array.array;

import java.util.Arrays;

public class SquareElement {
    public int[] sortedSquares(int[] nums) {
        return Arrays.stream(nums).boxed()
                .mapToInt(x -> (int) Math.pow(x, 2))
                .sorted()
                .toArray();
    }
}
