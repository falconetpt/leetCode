package exercises.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MinPathSum {
    public int minPathSum(int[][] grid) {
        return minPathSum( grid, 0, 0, new HashMap<>(  ) )
                .map( p -> p.runningSum )
                .orElse( 0 );
    }

    private Optional<Pair> minPathSum(int[][] grid, int row, int col, Map<String, Pair> cache) {
        if(row >= grid.length || col >= grid[row].length) {
            return Optional.empty();
        } else {
            int value = grid[row][col];
            String key = row + ":" + col;

            if (!cache.containsKey( key )) {
                Optional<Pair> down = minPathSum( grid, row + 1, col, cache );
                Optional<Pair> right = minPathSum( grid, row, col + 1, cache );

                Pair newPair;

                if (!down.isPresent() && !right.isPresent()) {
                    newPair = new Pair( 0, 0 );
                } else if (!down.isPresent() || !right.isPresent()) {
                    newPair = down.orElseGet( right::get );
                } else {
                    newPair = down.map( p -> p.runningSum ).orElse( Integer.MAX_VALUE )
                            > right.map( p -> p.runningSum ).orElse( Integer.MAX_VALUE ) ? right.get() : down.get();
                }

                cache.putIfAbsent( key, new Pair( newPair.runningSum + value, 1 + newPair.listSize ) );
            }

            return Optional.of( cache.get( key ) );

        }
    }

    private class Pair {
        int runningSum;
        int listSize;

        Pair(int runningSum, int listSize) {
            this.runningSum = runningSum;
            this.listSize = listSize;
        }
    }


    /**
     * https://leetcode.com/problems/minimum-path-sum/submissions/
     *
     * Given a m x n grid filled with non-negative numbers,
     * find a path from top left to bottom right which minimizes
     * the sum of all numbers along its path.
     *
     * Note: You can only move either down or right at any point in time.
     *
     * Example:
     *
     * Input:
     * [
     *   [1,3,1],
     *   [1,5,1],
     *   [4,2,1]
     * ]
     * Output: 7
     * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
     */
}
