package exercises.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SetMatrixZeroTest {
    private SetMatrixZero s = new SetMatrixZero();

    @Test
    @DisplayName("Empty set should return the same matrix")
    void test1() {
        int[][] matrix = new int[][] {};
        s.setZeroes(matrix);
        int[][] expected = new int[][]{};

        assertArrayEquals(expected, matrix);
    }

    @Test
    @DisplayName("Set of all 1s should return the same matrix")
    void test2() {
        int[][] matrix = new int[][] {
                { 1 }
        };
        s.setZeroes(matrix);
        int[][] expected = new int[][] {
                { 1 }
        };

        assertArrayEquals(expected, matrix);
    }

    @Test
    @DisplayName("Set of all 1s should return the same matrix")
    void test3() {
        int[][] matrix = new int[][] {
                { 1, 1, 1 },
                { 1, 1, 1 },
                { 1, 1, 1 }
        };
        s.setZeroes(matrix);
        int[][] expected = new int[][] {
                { 1, 1, 1 },
                { 1, 1, 1 },
                { 1, 1, 1 }
        };

        assertArrayEquals(expected, matrix);
    }

    @Test
    @DisplayName("Set of center 0 should return the a 0 cross matrix")
    void test4() {
        int[][] matrix = new int[][] {
                { 1, 1, 1 },
                { 1, 0, 1 },
                { 1, 1, 1 }
        };
        s.setZeroes(matrix);
        int[][] expected = new int[][] {
                { 1, 0, 1 },
                { 0, 0, 0 },
                { 1, 0, 1 }
        };

        assertArrayEquals(expected, matrix);
    }
}