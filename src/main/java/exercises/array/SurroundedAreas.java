package exercises.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class SurroundedAreas {

    public void solve(char[][] board) {
        final Map<Integer, Pair> columnRegister = new HashMap<>();
        final Map<Integer, Pair> rowRegister = new HashMap<>();
        final Set<Pair> toEvaluate = new HashSet<>();

        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                if (board[row][column] == 'O') {
                    if (isSurrounded(board, row, column)) {
                        board[row][column] = 'X';
                    } else {
                        toEvaluate.add(new Pair(row, column));
                    }
                } else {
                    if(rowRegister.containsKey(row)) {
                        rowRegister.get(row).second = column;
                    } else {
                        rowRegister.put(row, new Pair(column));
                    }

                    if(columnRegister.containsKey(column)) {
                        columnRegister.get(column).second = row;
                    } else {
                        columnRegister.put(column, new Pair(row));
                    }
                }
            }
        }

        toEvaluate.stream()
                .filter(p -> rowRegister.containsKey(p.first) && columnRegister.containsKey(p.second))
                .filter(p -> rowRegister.get(p.first).first.compareTo(p.second) < 0)
                .filter(p -> rowRegister.get(p.first).second.compareTo(p.second) > 0)
                .filter(p -> columnRegister.get(p.second).first.compareTo(p.first) < 0)
                .filter(p -> columnRegister.get(p.second).second.compareTo(p.first) > 0)
                .forEach(p -> board[p.first][p.second] = 'X');
    }

    private boolean isSurrounded(char[][] board, int row, int column) {
        try {
            boolean verticalMatch = board[row - 1][column] == 'X' && board[row + 1][column] == 'X';
            boolean horizontalMatch = board[row][column - 1] == 'X' && board[row][column + 1] == 'X';
            return verticalMatch && horizontalMatch;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    private class Pair {
        public Integer first;
        public Integer second = Integer.MIN_VALUE;

        Pair(int first) {
            this.first = first;
        }

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair pair = (Pair) o;
            return Objects.equals(first, pair.first) &&
                    Objects.equals(second, pair.second);
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
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
