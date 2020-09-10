package exercises.array;

import javax.management.Query;
import java.awt.Point;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OverlappingMatrix {

    public int largestOverlap(int[][] A, int[][] B) {
        Function<int[][], Set<Point>> getPoints = a -> IntStream.range( 0, a.length ).boxed()
                .flatMap( x -> IntStream.range( 0, a[x].length ).boxed()
                        .filter( y -> a[x][y] == 1 )
                        .map( y -> new Point( x, y ) )
                ).collect( Collectors.toSet());

        Set<Point> aPoints = getPoints.apply( A );
        Set<Point> bPoints = getPoints.apply( B );

        List<Point> moves = Arrays.asList(
          new Point( 1, 0 ),
          new Point( -1, 0 ),
          new Point( 0, 1 ),
          new Point( 0, -1 )
//          new Point( 1, 1 ),
//          new Point( -1, 1 ),
//          new Point( 1, -1 ),
//          new Point( -1, -1 )
        );



        Queue<Set<Point>> result1 = getRelativePoints( aPoints, new LinkedList<>(aPoints), new LinkedList<>(  ), moves);
        Queue<Set<Point>> result2 = getRelativePoints( bPoints, new LinkedList<>(bPoints), new LinkedList<>(  ), moves);

        int x = 0;

        for (Set<Point> p : result1) {
            for (Set<Point> p2 : result2) {
                x = Math.max( 0, (int) p.stream().filter( p2::contains ).count() );
            }
        }

        return x;
    }


    private Queue<Set<Point>> getRelativePoints(final Set<Point> knownPoints,
                                               final Queue<Point> pointList,
                                               final Queue<Set<Point>> result,
                                               final List<Point> moves) {
        if (pointList.isEmpty()) {
            return result;
        } else {
            Point next = pointList.poll();
            Set<Point> points = new HashSet<>(  );
            points.add( new Point( 0, 0 ) );

            expandPoint(pointList, next, moves, next, points);

            result.add( points );

            return getRelativePoints( knownPoints, pointList, result, moves );
        }
    }

    private void expandPoint(Queue<Point> pointList,
                                   Point next,
                                   List<Point> moves,
                                   Point base,
                                   Set<Point> result) {
        pointList.stream()
                .flatMap( p -> moves.stream()
                        .map( p1 -> new Point( p1.x + next.x, p1.y + next.y ) )
                        .filter( p1 -> p1.equals( p ) )
                )
                .collect( Collectors.toSet())
                .forEach( p1 -> {
                    pointList.remove(p1);
                    result.add( new Point(p1.x - base.x, p1.y - base.y ) );
                    expandPoint( pointList, p1, moves, base, result );
                } );
    }


    /**
     * Two images A and B are given, represented as binary, square matrices of the same size.  (A binary matrix has only 0s and 1s as values.)
     *
     * We translate one image however we choose (sliding it left, right, up, or down any number of units), and place it on top of the other image.  After, the overlap of this translation is the number of positions that have a 1 in both images.
     *
     * (Note also that a translation does not include any kind of rotation.)
     *
     * What is the largest possible overlap?
     *
     * Example 1:
     *
     * Input: A = [[1,1,0],
     *             [0,1,0],
     *             [0,1,0]]
     *        B = [[0,0,0],
     *             [0,1,1],
     *             [0,0,1]]
     * Output: 3
     * Explanation: We slide A to right by 1 unit and down by 1 unit.
     * Notes:
     *
     * 1 <= A.length = A[0].length = B.length = B[0].length <= 30
     * 0 <= A[i][j], B[i][j] <= 1
     */
}

