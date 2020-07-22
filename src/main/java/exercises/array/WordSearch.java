package exercises.array;

import java.awt.*;
import java.util.List;
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

        return IntStream.range( 0, board.length ).boxed()
                .flatMap( row ->
                        IntStream.range( 0, board[row].length ).boxed()
                                .filter( col -> board[row][col] == word.charAt( 0 ) )
                                .map( col -> new Point( row, col ) )
                )
                .anyMatch( p -> exist(board, word, moves, p, new int[board.length][board[0].length], 0) );
    }

    private boolean exist(char[][] board, String word, List<Point> moves, Point point, int[][] seen, int idx) {

        if(word.length() - 1 == idx) {
            return word.charAt(idx) == board[point.x][point.y];
        } else {
            char value = word.charAt( idx );
            boolean matches = board[point.x][point.y] == value;
            seen[point.x][point.y] = 1;

            boolean result = matches && moves.stream()
                    .map( p -> new Point( point.x + p.x, point.y + p.y ) )
                    .filter( p -> validCell(board, p) )
                    .filter( p -> seen[p.x][p.y] == 0)
                    .map( p -> exist(board, word, moves, p, seen, idx + 1) )
                    .reduce( false, (a, b) -> a || b );

            if (!result) seen[point.x][point.y] = 0;

            return result;
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
