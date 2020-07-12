package exercises.array;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        } else {
            Queue<Point> islands = IntStream.range( 0, grid.length ).boxed()
                    .flatMap( r -> IntStream.range( 0, grid[r].length ).boxed()
                            .map( c -> new Point( r, c ) ) )
                    .filter( p -> isLand( grid, p ) )
                    .collect( Collectors.toCollection( LinkedList::new ) );

            List<Point> moves = Stream.of(
                    new Point( 1, 0 ),
                    new Point( -1, 0 ),
                    new Point( 0, 1 ),
                    new Point( 0, -1 )
            ).collect( Collectors.toList() );

            return islandPerimeter( grid, islands, moves, 0 );
        }
    }


    private int islandPerimeter(int[][] grid,
                               Queue<Point> islands,
                               List<Point> moves,
                               int perimeter) {
        if (islands.isEmpty()) {
            return perimeter;
        } else {
            Point next = islands.poll();
            long newPerimeter = 4 - moves.stream()
                    .map( m -> new Point( next.x + m.x, next.y + m.y ) )
                    .filter( e -> isLand( grid, e ) )
                    .count() + perimeter;
            return islandPerimeter( grid, islands, moves, (int) newPerimeter );
        }
    }

    private boolean isLand(int[][] grid, Point point) {
        try {
            return grid[point.x][point.y] == 1;
        } catch (Exception e) {
            return false;
        }
    }
}
