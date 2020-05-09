package exercises.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxAreaOfIslandTest {
    private MaxAreaOfIsland m = new MaxAreaOfIsland();

    @Test
    void maxAreaOfIsland() {
        int result = m.maxAreaOfIsland(
                new int[][]{
                    {1,1,0,0,0},
                    {1,1,0,0,0},
                    {0,0,0,1,1},
                    {0,0,0,1,1}
                }
        );
        int expected = 4;

        assertEquals( expected, result );
    }

    @Test
    void maxAreaOfIsland2() {
        int result = m.maxAreaOfIsland(
                new int[][]{
                        {0,0,1,0,0,0,0,1,0,0,0,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,1,1,0,1,0,0,0,0,0,0,0,0},
                        {0,1,0,0,1,1,0,0,1,0,1,0,0},
                        {0,1,0,0,1,1,0,0,1,1,1,0,0},
                        {0,0,0,0,0,0,0,0,0,0,1,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,0,0,0,0,0,0,1,1,0,0,0,0}
                }
        );
        int expected = 6;

        assertEquals( expected, result );
    }
}