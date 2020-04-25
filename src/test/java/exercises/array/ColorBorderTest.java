package exercises.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColorBorderTest {
    private ColorBorder c = new ColorBorder();

    @Test
    void scenario1() {
        int[][] result = c.colorBorder(
                new int[][] {
                        { 1, 1 },
                        { 1, 2 }
                }, 0, 0, 3
        );

        int[][] expected = new int[][] {
                { 3, 3 },
                { 3, 2 }
        };

        assertArrayEquals(expected, result);
    }

    @Test
    void scenario2() {
        int[][] result = c.colorBorder(
                new int[][] {
                        { 1,2,2 },
                        { 2,3,2 }
                }, 0, 1, 3
        );

        int[][] expected = new int[][] {
                { 1, 3, 3 },
                { 2, 3, 3 }
        };

        assertArrayEquals(expected, result);
    }

    @Test
    void scenario3() {
        int[][] result = c.colorBorder(
                new int[][] {
                        { 1,1,1 },
                        { 1,1,1 },
                        { 1,1,1 }
                }, 1, 1, 2
        );

        int[][] expected = new int[][] {
                { 2, 2, 2 },
                { 2, 1, 2 },
                { 2, 2, 2 }
        };

        assertArrayEquals(expected, result);
    }

    @Test
    void scenario4() {
        int[][] result = c.colorBorder(
                new int[][] {
                        { 1,2,1 },
                        { 1,2,2 },
                        { 2,2,1 }
                }, 1, 1, 2
        );

        int[][] expected = new int[][] {
                { 2, 2, 2 },
                { 2, 1, 2 },
                { 2, 2, 2 }
        };

        assertArrayEquals(expected, result);
    }
}