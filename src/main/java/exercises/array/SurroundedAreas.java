package exercises.array;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SurroundedAreas {

    public void solve(char[][] board) {
        if (board.length > 0 && board[0].length > 0) {
            Set<Pair> moves = Stream.of(
                    new Pair(1, 0),
                    new Pair(0, 1),
                    new Pair(-1, 0),
                    new Pair(0, -1)
            ).collect(Collectors.toSet());

            Set<Pair> findAllOInBorders = findAll0InBorders(board);
            expand0s(board, findAllOInBorders, moves);

            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[row].length; col++) {
                    if(board[row][col] == 'O') {
                        board[row][col] = 'X';
                    } else if(board[row][col] == '*') {
                        board[row][col] = 'O';
                    }
                }
            }
        }
    }

    private void expand0s(char[][] board, Set<Pair> remainingPairs, Set<Pair> moves) {
        if (!remainingPairs.isEmpty()) {
            Pair base = remainingPairs.iterator().next();
            board[base.row][base.col] = '*';

            moves.stream()
                    .map(m -> new Pair(base.row + m.row, base.col + m.col))
                    .filter(m -> isValid0(board, m.row, m.col))
                    .forEach(remainingPairs::add);
            remainingPairs.remove(base);
            expand0s(board, remainingPairs, moves);
        }
    }

    private boolean isValid0(char[][] board, int row, int col) {
        try {
            return board[row][col] == 'O';
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    private Set<Pair> findAll0InBorders(char[][] board) {
        Set<Pair> result = new HashSet<>();

        IntStream.range(0, board[0].length).boxed()
                .filter(i -> board[0][i] == 'O')
                .map(i -> new Pair(0, i))
                .forEach(result::add);

        IntStream.range(0, board[0].length).boxed()
                .filter(i -> board[board.length-1][i] == 'O')
                .map(i -> new Pair(board.length-1, i))
                .forEach(result::add);

        IntStream.range(0, board.length).boxed()
                .filter(i -> board[i][0] == 'O')
                .map(i -> new Pair(i, 0))
                .forEach(result::add);

        IntStream.range(0, board.length).boxed()
                .filter(i -> board[i][board[0].length - 1] == 'O')
                .map(i -> new Pair( i, board[0].length - 1))
                .forEach(result::add);

        return result;
    }


    public class Pair {
        public int row;
        public int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair pair = (Pair) o;
            return Objects.equals(row, pair.row) &&
                    Objects.equals(col, pair.col);
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }

    /**
     * https://leetcode.com/problems/surrounded-regions/
     *
     * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
     *
     * A region is captured by flipping all 'O's into 'X's in that surrounded region.
     *
     * Example:
     *
     * X X X X
     * X O O X
     * X X O X
     * X O X X
     * After running your function, the board should be:
     *
     * X X X X
     * X X X X
     * X X X X
     * X O X X
     * Explanation:
     *
     * Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board
     * are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border
     * will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
     */
}
