package exercises.array.array;

import java.awt.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        LinkedList<Point> landCoordinates = getLandCoordinates(grid);
        List<Point> moves = Stream.of(
            new Point( 0, 1 ),
            new Point( 0, -1 ),
            new Point( 1, 0 ),
            new Point( -1, 0 )
        ).collect( Collectors.toList());

        return maxAreaOfIsland( landCoordinates, new HashSet<>( landCoordinates ), moves );
    }

    private int maxAreaOfIsland(LinkedList<Point> landCoordinates,
                                Set<Point> points,
                                List<Point> moves) {
        if (landCoordinates.isEmpty()) {
            return 0;
        } else {
            Point next = landCoordinates.pop();
            int area = points.contains( next ) ? getLandArea(
                    points,
                    Stream.of( next ).collect( Collectors.toCollection(LinkedList::new)),
                    moves
                    ) : 0;
            return Math.max( area, maxAreaOfIsland( landCoordinates, points, moves ) );
        }
    }

    private int getLandArea(Set<Point> landCoordinates,
                            LinkedList<Point> expansion,
                            List<Point> moves) {
        if (expansion.isEmpty()) {
            return 0;
        } else {
            Point next = expansion.pop();
            landCoordinates.remove( next );
            moves.stream()
                    .map( p -> new Point( p.x + next.x, p.y + next.y ) )
                    .filter( landCoordinates::contains )
                    .forEach( p -> {
                        expansion.add( p );
                        landCoordinates.remove( p );
                    } );
            return 1 + getLandArea( landCoordinates, expansion, moves );
        }

    }

    private LinkedList<Point> getLandCoordinates(int[][] grid) {
        return IntStream.range( 0, grid.length ).boxed()
                .flatMap( r ->
                        IntStream.range( 0, grid[r].length ).boxed()
                                .filter( c -> grid[r][c] == 1 )
                                .map( c -> new Point( r, c ) )
                ).collect( Collectors.toCollection( LinkedList::new ) );
    }

    /**
     *
     * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land)
     * connected 4-directionally (horizontal or vertical.)
     * You may assume all four edges of the grid are surrounded by water.
     *
     * Find the maximum area of an island in the given 2D array.
     * (If there is no island, the maximum area is 0.)
     *
     * Example 1:
     *
     * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
     *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
     *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
     *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
     *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
     *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
     *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
     *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
     * Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
     * Example 2:
     *
     * [[0,0,0,0,0,0,0,0]]
     * Given the above grid, return 0.
     * Note: The length of each dimension in the given grid does not exceed 50.
     */
}
