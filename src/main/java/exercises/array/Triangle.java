package exercises.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        return recursiveSum(triangle, 0, 0, new HashMap<>(  ) );
    }

    public int recursiveSum(List<List<Integer>> triangle, int row, int col, Map<String, Integer> cache) {
        if(row >= triangle.size() || col >= triangle.get( row ).size()) {
            return 0;
        } else {
            String key = row + ":" + col;

            if (!cache.containsKey( key )) {
                int value = triangle.get( row ).get( col )
                        + Math.min(
                        recursiveSum( triangle, row + 1, col, cache ),
                        recursiveSum( triangle, row + 1, col + 1, cache)
                );

                cache.putIfAbsent( key, value );
            }

            return cache.get( key );
        }
    }



    /**
     * https://leetcode.com/problems/triangle/
     *
     * Given a triangle, find the minimum path sum from top to bottom.
     * Each step you may move to adjacent numbers on the row below.
     *
     * For example, given the following triangle
     *
     * [
     *      [2],
     *     [3,4],
     *    [6,5,7],
     *   [4,1,8,3]
     * ]
     * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
     *
     * Note:
     *
     * Bonus point if you are able to do this using only O(n) extra space,
     * where n is the total number of rows in the triangle.
     */
}
