package exercises.array;

import java.awt.Point;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        List<Point> moves = Stream.of(
                new Point(1, 0),
                new Point(0, 1),
                new Point(0, -1),
                new Point(-1, 0)
        ).collect( Collectors.toList());

        List<Point> beggining = IntStream.range( 0, board.length ).boxed()
                .flatMap( row ->
                        IntStream.range( 0, board[row].length ).boxed()
                                .filter( col -> board[row][col] == word.charAt( 0 ) )
                                .map( col -> new Point( row, col ) )
                )
                .collect( Collectors.toList() );

        if (word.length() == 1 && !beggining.isEmpty()) return true;

        return beggining.stream().anyMatch( p -> exist(board, word, moves, p, new HashSet<>()) );
    }

    private boolean exist(char[][] board, String word, List<Point> moves, Point point, Set<Point> visited) {
        if (word.isEmpty()) {
            return true;
        } else if(word.length() == 1) {
            return word.charAt(0) == board[point.x][point.y];
        } else {
            char value = word.charAt( 0 );
            boolean matches = board[point.x][point.y] == value;
            Set<Point> newSet = new HashSet<>( visited );
            newSet.add( point );

            return matches && moves.stream()
                    .map( p -> new Point( point.x + p.x, point.y + p.y ) )
                    .filter( p -> validCell(board, p) )
                    .filter( p -> !newSet.contains( p ) )
                    .map( p -> exist(board, word.substring( 1 ), moves, p, newSet) )
                    .reduce( false, (a, b) -> a || b );
        }
    }

    private boolean validCell(char[][] board, Point p) {
        try {
            int value = board[p.x][p.y];
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
