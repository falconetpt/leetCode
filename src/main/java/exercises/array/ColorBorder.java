package exercises.array;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ColorBorder {
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        int[][] newGrid = grid.clone();
        if (grid.length == 0 || grid[0].length == 0 || grid[r0][c0] == color) {
            return newGrid;
        } else {
            List<Coordinate> moves = Stream.of(
                    new Coordinate(1, 0),
                    new Coordinate(0, 1),
                    new Coordinate(0, -1),
                    new Coordinate(-1, 0)
            ).collect(Collectors.toList());

            LinkedList<Coordinate> surroundingColors = new LinkedList<>();

            int initialColor = grid[r0][c0];
            Coordinate initialCoordinate = new Coordinate(r0, c0);
            Consumer<Coordinate> registerUnvisitedPlanes = next -> moves.stream()
                    .map(m -> new Coordinate(next.row + m.row, next.col + m.col))
                    .filter(c -> matchesColor(newGrid, c, initialColor))
                    .forEach(surroundingColors::add);

            if (matchesColor(newGrid, initialCoordinate, initialColor)) surroundingColors.add(initialCoordinate);
            registerUnvisitedPlanes.accept(initialCoordinate);

            colorSurroundings(newGrid, surroundingColors, registerUnvisitedPlanes, color);
            return newGrid;
        }
    }

    private void colorSurroundings(int[][] grid, LinkedList<Coordinate> surroundingColors,
                                  Consumer<Coordinate> registerUnvisitedPlanes ,
                                  int color) {
        if(!surroundingColors.isEmpty()) {
            Coordinate next = surroundingColors.pop();
            grid[next.row][next.col] = color;

            registerUnvisitedPlanes.accept(next);

            colorSurroundings(grid, surroundingColors, registerUnvisitedPlanes, color);
        }
    }

    private boolean matchesColor(int[][] grid, Coordinate c, int initialColor) {
        try {
            boolean isBorderRow = c.row == 0 || c.row == grid.length - 1;
            boolean isBorderColumn = c.col == 0 || c.col == grid[c.row].length - 1;
            return (isBorderRow || isBorderColumn) && grid[c.row][c.col] == initialColor;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    private class Coordinate {
        int row;
        int col;

        public Coordinate(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    /**
     * https://leetcode.com/problems/coloring-a-border/
     *
     * Given a 2-dimensional grid of integers, each value in the grid represents the color of the grid square at that location.
     *
     * Two squares belong to the same connected component if and only if they have the same color and are next to each other in any of the 4 directions.
     *
     * The border of a connected component is all the squares in the connected component that are either 4-directionally adjacent to a square not in the component, or on the boundary of the grid (the first or last row or column).
     *
     * Given a square at location (r0, c0) in the grid and a color, color the border of the connected component of that square with the given color, and return the final grid.
     *
     *
     *
     * Example 1:
     *
     * Input: grid = [[1,1],[1,2]], r0 = 0, c0 = 0, color = 3
     * Output: [[3, 3], [3, 2]]
     * Example 2:
     *
     * Input: grid = [[1,2,2],[2,3,2]], r0 = 0, c0 = 1, color = 3
     * Output: [[1, 3, 3], [2, 3, 3]]
     * Example 3:
     *
     * Input: grid = [[1,1,1],[1,1,1],[1,1,1]], r0 = 1, c0 = 1, color = 2
     * Output: [[2, 2, 2], [2, 1, 2], [2, 2, 2]]
     *
     *
     * Note:
     *
     * 1 <= grid.length <= 50
     * 1 <= grid[0].length <= 50
     * 1 <= grid[i][j] <= 1000
     * 0 <= r0 < grid.length
     * 0 <= c0 < grid[0].length
     * 1 <= color <= 1000
     */
}
