package exercises.array;

import java.awt.Point;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class UniquePaths3 {
    public int uniquePathsIII(final int[][] grid) {
        final Set<Point> zeroPoints = IntStream.range( 0, grid.length ).boxed()
                .flatMap(
                        x -> IntStream.range( 0, grid[x].length ).boxed()
                                .map( y -> new Point( x, y ) )
                )
                .collect( Collectors.toSet() );

        final List<Point> moves = Stream.of(
                new Point( 0, 1 ),
                new Point( 0, -1 ),
                new Point( 1, 0 ),
                new Point( -1, 0 )
        ).collect( Collectors.toList());


        final Point startPoint = IntStream.range( 0, grid.length ).boxed()
                .flatMap(
                        x -> IntStream.range( 0, grid[x].length ).boxed()
                                .map( y -> new Point( x, y ) )
                )
                .filter( x -> grid[x.x][x.y] == 1 )
                .findFirst()
                .orElse( null );

        final Point finalPoint = IntStream.range( 0, grid.length ).boxed()
                .flatMap(
                        x -> IntStream.range( 0, grid[x].length ).boxed()
                                .map( y -> new Point( x, y ) )
                )
                .filter( x -> grid[x.x][x.y] == 2 )
                .findFirst()
                .orElse( null );

        // DFS application to the starting point

        return uniquePathsIII( startPoint, finalPoint, moves, zeroPoints );
    }

    private int uniquePathsIII(final Point startPoint,
                               final Point finalPoint,
                               final List<Point> moves,
                               final Set<Point> zeroPoints) {
        return 0;
    }
}
