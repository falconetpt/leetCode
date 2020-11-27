package exercises.array;

import java.util.Objects;
import java.util.TreeMap;

public class TrapRainWatter {
    public int trap(int[] height) {
        if (height == null || height.length < 3) return 0;
        return trap( height, 0, height.length - 1, height[0], height[height.length - 1]);
    }

    private int trap(int[] height, int start, int end, int maxLeft, int maxRight) {
        if (start == end) {
            return 0;
        } else {
            if (height[end] > height[start]) {
                int newMaxLeft = Math.max( maxLeft, height[start] );
                int result = Math.max( 0, newMaxLeft - height[start] );
                return result + trap( height, start + 1, end, newMaxLeft, maxRight );
            } else {
                int newMaxRight = Math.max( maxRight, height[end] );
                int result = Math.max( 0, newMaxRight - height[end] );
                return result + trap( height, start, end - 1, maxLeft, newMaxRight );
            }
        }
    }
}
