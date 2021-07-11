package exercises.array.array;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class KnightProbabilityInChessBoard {
    public double knightProbability(int N, int K, int r, int c) {
        List<Pair> moves = Stream.of(
                new Pair(2, 1),
                new Pair(2, -1),
                new Pair(1, 2),
                new Pair(-1, 2),
                new Pair(-2, 1),
                new Pair(-2, -1),
                new Pair(1, -2),
                new Pair(-1, -2)
        ).collect(Collectors.toList());

        if(K == 0) {
            return isValid(N, r, c) ? 1 : 0;
        } else {
            return calculateProbability(N, K, r, c, moves, new HashMap<>()).divide(
                    BigDecimal.valueOf(Math.pow(8, K)), 10, RoundingMode.HALF_EVEN
            ).doubleValue();
        }
    }

    private BigDecimal calculateProbability(int matrixSize, int hops, int r, int c, List<Pair> moves, Map<String, BigDecimal> cache) {
        if (hops == 0) {
            return BigDecimal.ONE;
        } else {
            String key = r +  ":" + c + ":" + hops;
            if(cache.containsKey(key)) {
                return cache.get(key);
            } else {
                List<Pair> nextPositions = moves.stream()
                        .map(move -> new Pair(move.rowIndex + r, move.colIndex + c))
                        .filter(coord -> isValid(matrixSize, coord.rowIndex, coord.colIndex))
                        .collect(Collectors.toList());
                BigDecimal result = nextPositions.stream()
                        .map(p -> calculateProbability(matrixSize, hops - 1, p.rowIndex, p.colIndex, moves, cache))
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
                cache.putIfAbsent(key, result);
                return result;
            }
        }
    }

    public boolean isValid(final int matrixSize, final int row, final int col) {
        return (row >= 0 && row < matrixSize) && (col >= 0 && col < matrixSize);
    }

    public class Pair {
        private int rowIndex;
        private int colIndex;

        public Pair(int rowIndex, int colIndex) {
            this.rowIndex = rowIndex;
            this.colIndex = colIndex;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair pair = (Pair) o;
            return rowIndex == pair.rowIndex &&
                    colIndex == pair.colIndex;
        }

        @Override
        public int hashCode() {
            return Objects.hash(rowIndex, colIndex);
        }
    }

/**
 * https://leetcode.com/problems/knight-probability-in-chessboard/
 *
 * On an NxN chessboard, a knight starts at the r-th row and c-th column and attempts to make exactly K moves.
 * The rows and columns are 0 indexed, so the top-left square is (0, 0), and the bottom-right square is (N-1, N-1).
 *
 * A chess knight has 8 possible moves it can make, as illustrated below.
 * Each move is two squares in a cardinal direction, then one square in an orthogonal direction.
 *
 *
 *
 *
 *
 *
 *
 * Each time the knight is to move, it chooses one of eight possible moves uniformly at random
 * (even if the piece would go off the chessboard) and moves there.
 *
 * The knight continues moving until it has made exactly K moves or has moved off the chessboard.
 * Return the probability that the knight remains on the board after it has stopped moving.
 *
 *
 *
 * Example:
 *
 * Input: 3, 2, 0, 0
 * Output: 0.0625
 * Explanation: There are two moves (to (1,2), (2,1)) that will keep the knight on the board.
 * From each of those positions, there are also two moves that will keep the knight on the board.
 * The total probability the knight stays on the board is 0.0625.
 *
 *
 * Note:
 *
 * N will be between 1 and 25.
 * K will be between 0 and 100.
 * The knight always initially starts on the board.
 */
}
