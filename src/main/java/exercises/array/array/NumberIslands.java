package exercises.array.array;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumberIslands {

    public int numIslands(char[][] grid) {
        Set<Pair> onesFound = obtainsCoordinatesOfIslands(grid);
        List<Pair> movesWithoutDiagonals = Stream.of(
                new Pair(0, 1),
                new Pair(0, -1),
                new Pair(1, 0),
                new Pair(-1, 0)

        ).collect(Collectors.toList());

        return countIslasnds(onesFound, movesWithoutDiagonals);
    }

    private int countIslasnds(final Set<Pair> onesFound, final List<Pair> moves) {
        if(onesFound.isEmpty()) {
            return 0;
        } else {
            Set<Pair> root = onesFound.stream().limit(1).collect(Collectors.toSet());
            groupIslands(root, onesFound, moves);
            return 1 + countIslasnds(onesFound, moves);
        }
    }

    private void groupIslands(final Set<Pair> roots, final Set<Pair> onesFound, final List<Pair> moves ) {
        if (!roots.isEmpty()) {
            onesFound.removeAll(roots);
            Set<Pair> newRoots = roots.stream().flatMap(
                    pair -> moves.stream()
                            .map(move -> new Pair(pair.rowIndex + move.rowIndex, pair.colIndex + move.colIndex))
            ).filter(onesFound::contains).collect(Collectors.toSet());
            groupIslands(newRoots, onesFound, moves);
        }
    }

    public Set<Pair> obtainsCoordinatesOfIslands(final char[][] grid) {
        return IntStream.range(0, grid.length).boxed().flatMap(
                row -> IntStream.range(0, grid[row].length).boxed()
                        .filter(col -> grid[row][col] == '1')
                        .map(col -> new Pair(row, col))
        ).collect(Collectors.toSet());
    }


    private class Pair {
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
     * https://leetcode.com/problems/number-of-islands/
     * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
     * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
     * You may assume all four edges of the grid are all surrounded by water.
     *
     * Example 1:
     *
     * Input:
     * 11110
     * 11010
     * 11000
     * 00000
     *
     * Output: 1
     * Example 2:
     *
     * Input:
     * 11000
     * 11000
     * 00100
     * 00011
     *
     * Output: 3
     */
}