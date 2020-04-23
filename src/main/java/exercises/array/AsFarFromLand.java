package exercises.array;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AsFarFromLand {
    public int maxDistance(int[][] grid) {
        LinkedList<Coordinate> land = new LinkedList<>(getLandCoordinates(grid));
        List<Coordinate> moves = Stream.of(
                new Coordinate(0, 1),
                new Coordinate(1, 0),
                new Coordinate(0, -1),
                new Coordinate(-1, 0)
        ).collect(Collectors.toList());

        return land.size() == 0 ? -1 : calculateMaxDistance(grid, land, moves, new HashMap<>());
    }

    private int calculateMaxDistance(int[][] grid,
                                     LinkedList<Coordinate> land,
                                     List<Coordinate> moves,
                                     Map<Coordinate, Integer> cache) {
        if (land.isEmpty()) {
            return cache.values().stream().reduce(-1, Math::max);
        } else {
            Coordinate next = land.pollFirst();
            LinkedList<Coordinate> surroundingSea = moves.stream()
                    .map(m -> new Coordinate(m.x + next.x, m.y + next.y ))
                    .filter(c -> isValidCoordenate(grid, c))
                    .collect(Collectors.toCollection(LinkedList::new));

            landExpansion(grid, next, surroundingSea, moves, cache);
            return calculateMaxDistance(grid, land, moves, cache);
        }
    }

    private void landExpansion(int[][] grid,
                               Coordinate baseLandCoordinate,
                               LinkedList<Coordinate> surroundingSea,
                               List<Coordinate> moves,
                               Map<Coordinate, Integer> cache) {
        if (!surroundingSea.isEmpty()) {
            Coordinate next = surroundingSea.pollFirst();

            Predicate<Coordinate> isLesser = c -> {
                if (cache.containsKey(c)) {
                    return calculateManhattanDistance(baseLandCoordinate, c) < cache.get(c);
                } else {
                    return true;
                }
            };

            if (cache.containsKey(next) && calculateManhattanDistance(baseLandCoordinate, next) < cache.get(next)) {
                cache.put(next, calculateManhattanDistance(baseLandCoordinate, next));
            }

            Consumer<Coordinate> cacheAndAddToSurroundingSea = c -> {
                cache.put(c, calculateManhattanDistance(baseLandCoordinate, c));
                surroundingSea.add(c);
            };

            moves.stream()
                    .map(m -> new Coordinate(m.x + next.x, m.y + next.y ))
                    .filter(c -> isValidCoordenate(grid, c))
                    .filter(isLesser)
                    .forEach(cacheAndAddToSurroundingSea);

            landExpansion(grid, baseLandCoordinate, surroundingSea, moves, cache);
        }
    }

    private boolean isValidCoordenate(int[][] grid, Coordinate coordinate) {
        try {
            return grid[coordinate.y][coordinate.x] == 0;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    private int calculateManhattanDistance(Coordinate a, Coordinate b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }

    private List<Coordinate> getLandCoordinates(int[][] grid) {
        return IntStream.range(0, grid.length).boxed()
                .flatMap(
                        y -> IntStream.range(0, grid[y].length)
                                .filter(x -> grid[y][x] == 1)
                                .mapToObj(x -> new Coordinate(x, y))
                ).collect(Collectors.toList());
    }

    private class Coordinate {
        int x;
        int y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Coordinate)) return false;
            Coordinate that = (Coordinate) o;
            return x == that.x &&
                    y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    /**
     * https://leetcode.com/problems/as-far-from-land-as-possible/
     *
     * Given an N x N grid containing only values 0 and 1, where 0 represents water and 1 represents land, find a water cell such that its distance to the nearest land cell is maximized and return the distance.
     *
     * The distance used in this problem is the Manhattan distance: the distance between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.
     *
     * If no land or water exists in the grid, return -1.
     *
     *
     *
     * Example 1:
     *
     *
     *
     * Input: [[1,0,1],[0,0,0],[1,0,1]]
     * Output: 2
     * Explanation:
     * The cell (1, 1) is as far as possible from all the land with distance 2.
     * Example 2:
     *
     *
     *
     * Input: [[1,0,0],[0,0,0],[0,0,0]]
     * Output: 4
     * Explanation:
     * The cell (2, 2) is as far as possible from all the land with distance 4.
     *
     *
     * Note:
     *
     * 1 <= grid.length == grid[0].length <= 100
     * grid[i][j] is 0 or 1
     */
}
