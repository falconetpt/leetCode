package exercises.array.array;

import java.awt.Point;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LonguestIncreasingPath {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        } else {
            LinkedList<Point> points = IntStream.range( 0, matrix.length ).boxed()
                    .flatMap( row -> IntStream.range( 0, matrix[row].length ).boxed()
                            .map( col -> new Point( row, col ) ) )
                    .sorted( Comparator.comparingInt( a -> matrix[a.x][a.y] ) )
                    .collect( Collectors.toCollection(LinkedList::new) );

            List<Point> moves = Stream.of(
                    new Point( 1, 0 ),
                    new Point( -1, 0 ),
                    new Point( 0, 1 ),
                    new Point( 0, -1 )
            ).collect( Collectors.toList());

            return longestIncreasingPath(matrix, points, moves, new HashMap<>(  ) );
        }
    }

    private int longestIncreasingPath(final int[][] matrix,
                                      final LinkedList<Point> points,
                                      final List<Point> moves,
                                      final Map<Point, Integer> cache) {
        if (points.isEmpty()) {
            return 0;
        } else {
            Point next = points.pollFirst();
            int maxValue = longestIncreasingPath(matrix, next, moves, cache);
            cache.put( next, maxValue );

            return Math.max(maxValue , longestIncreasingPath( matrix, points, moves, cache ) );
        }
    }

    private int longestIncreasingPath(final int[][] matrix,
                                      final Point point,
                                      final List<Point> moves,
                                      final Map<Point, Integer> cache) {
        if (cache.containsKey( point )) {
            return cache.get( point );
        } else {
            List<Point> nextMoves = moves.stream()
                    .map( p -> new Point( point.x + p.x, point.y + p.y ) )
                    .filter( p -> isValidCell( matrix, point, p ) )
                    .collect( Collectors.toList());

            int maxValue = 1 + nextMoves.stream()
                    .map( p -> longestIncreasingPath( matrix, p, moves, cache ) )
                    .reduce( 0, Math::max );

            return maxValue;
        }
    }

    private boolean isValidCell(final int[][] matrix,
                                final Point initial,
                                final Point target) {
        try {
            return matrix[target.x][target.y] > matrix[initial.x][initial.y];
        } catch (Exception e) {
            return false;
        }
    }
}
