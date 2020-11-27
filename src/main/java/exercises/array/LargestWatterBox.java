package exercises.array;

import java.util.stream.IntStream;

public class LargestWatterBox {
    public int maxArea(int[] height) {
        return maxArea( height, 0, height.length - 1, 0 );
    }

    private int maxArea(int[] height, int start, int end, int result) {
        if (start >= end) {
            return result;
        } else {
            int heightStart = height[start];
            int heightEnd = height[end];
            int minHeight = Math.min( heightStart, heightEnd );

            if (heightStart > heightEnd) {
                return maxArea(
                        height, start, end -1,
                        Math.max( minHeight * (end - start), result )
                );
            } else {
                return maxArea(
                        height, start + 1, end,
                        Math.max( minHeight * (end - start), result )
                );
            }
        }
    }
}
