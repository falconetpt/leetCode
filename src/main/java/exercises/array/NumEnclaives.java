package exercises.array;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumEnclaives {
    public int numEnclaves(int[][] A) {
        if(A == null || A.length == 0) {
            return 0;
        } else {
            Set<Point> landSet = IntStream.range( 0, A.length ).boxed().flatMap(
                    row -> IntStream.range( 0, A[row].length ).boxed()
                        .map( col -> new Point( row, col ) )
            ).collect( Collectors.toSet());

            LinkedList<Point> landQueue = new LinkedList<>( landSet );
            List<Point> moves = Stream.of(
                    new Point( 1, 0 ),
                    new Point( 0, 1 ),
                    new Point( 0, -1 ),
                    new Point( -1, 0 )
            ).collect( Collectors.toList());

            return numEnclaves( A, landQueue, landSet, moves );
        }
    }

    public int numEnclaves(int[][] A, LinkedList<Point> points, Set<Point> toSee, List<Point> moves) {
        if (points.isEmpty()) {
            return 0;
        } else {
            Point next = points.pollFirst();
            toSee.remove( next );

            List<Point> nextPoints = moves.stream()
                    .map( p -> new Point( next.x + p.x, next.y + p.y ) )
                    .collect( Collectors.toList());

            boolean hasBorder = nextPoints.stream().anyMatch( p -> isBorder( A, p.x, p.y ) );

            if (hasBorder) {
                return 1 + numEnclaves( A, points, toSee, moves );
            } else {
                LinkedList<Point> nextList = nextPoints.stream()
                        .filter( toSee::contains )
                        .collect( Collectors.toCollection( LinkedList::new ) );
                int result = numEnclaves( A, points, toSee, moves );

                return result > 0
                        ? result + 1 + numEnclaves( A, nextList, toSee, moves )
                        : numEnclaves( A, nextList, toSee, moves );
            }
        }
    }


    boolean isBorder(int[][] A, int row, int col) {
        return  row < 0 || col < 0 ||
                row >= A.length || col >= A[row].length;

    }

    /**
     * https://leetcode.com/problems/number-of-enclaves/
     *
     * Given a 2D array A, each cell is 0 (representing sea) or 1 (representing land)
     *
     * A move consists of walking from one land square 4-directionally to another land square, or off the boundary of the grid.
     *
     * Return the number of land squares in the grid for which we cannot walk off the boundary of the grid in any number of moves.
     *
     *
     *
     * Example 1:
     *
     * Input: [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
     * Output: 3
     * Explanation:
     * There are three 1s that are enclosed by 0s, and one 1 that isn't enclosed because its on the boundary.
     * Example 2:
     *
     * Input: [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
     * Output: 0
     * Explanation:
     * All 1s are either on the boundary or can reach the boundary.
     *
     *
     * Note:
     *
     * 1 <= A.length <= 500
     * 1 <= A[i].length <= 500
     * 0 <= A[i][j] <= 1
     * All rows have the same size.
     */
}

