package exercises.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberIslandsTest {
    private NumberIslands n;

    @BeforeEach
    void init() {
        n = new NumberIslands();
    }


    @Test
    void numIslandsWithEmptyArray() {
        int result = n.numIslands(new char[][]{
        });
        int expectedResult = 0;

        assertEquals(expectedResult, result);
    }

    @Test
    void numIslandsWithArrayOfEmptyArrays() {
        int result = n.numIslands(new char[][]{
                new char[] { },
                new char[] { },
                new char[] { }
        });
        int expectedResult = 0;

        assertEquals(expectedResult, result);
    }

    @Test
    void numIslandsWithArrayOfOnlySea() {
        int result = n.numIslands(new char[][]{
                new char[] { '0', '0', '0' },
                new char[] { '0', '0', '0' },
                new char[] { '0', '0', '0' }
        });
        int expectedResult = 0;

        assertEquals(expectedResult, result);
    }

    @Test
    void numIslandsWithArrayOfSingleElementIsland() {
        int result = n.numIslands(new char[][]{
                new char[] { '1' }
        });
        int expectedResult = 1;

        assertEquals(expectedResult, result);
    }

    @Test
    void numIslandsWithArrayOfMultipleElementsSurroundedByWater_scenario1() {
        int result = n.numIslands(new char[][]{
                new char[] { '1', '0', '0' },
                new char[] { '0', '0', '0' },
                new char[] { '0', '0', '1' }
        });
        int expectedResult = 2;

        assertEquals(expectedResult, result);
    }

    @Test
    void numIslandsWithArrayOfMultipleElementsSurroundedByWater_scenario2() {
        int result = n.numIslands(new char[][]{
                new char[] { '1', '0', '1' },
                new char[] { '0', '0', '0' },
                new char[] { '0', '0', '0' }
        });
        int expectedResult = 2;

        assertEquals(expectedResult, result);
    }

    @Test
    void numIslandsWithArrayOfMultipleElementsSurroundedByWater_scenario3() {
        int result = n.numIslands(new char[][]{
                new char[] { '1', '0', '0' },
                new char[] { '0', '0', '0' },
                new char[] { '1', '0', '0' }
        });
        int expectedResult = 2;

        assertEquals(expectedResult, result);
    }

    @Test
    void numIslandsWithArrayOfMultipleElementsSurroundedByWater_scenario4() {
        int result = n.numIslands(new char[][]{
                new char[] { '1', '0', '0' },
                new char[] { '0', '0', '0' },
                new char[] { '0', '1', '0' }
        });
        int expectedResult = 2;

        assertEquals(expectedResult, result);
    }

    @Test
    void numIslandsWithArrayOfMultipleElementsSurroundedByWater_scenario5() {
        int result = n.numIslands(new char[][]{
                new char[] { '1', '0', '0' },
                new char[] { '0', '0', '1' },
                new char[] { '0', '0', '0' }
        });
        int expectedResult = 2;

        assertEquals(expectedResult, result);
    }

    @Test
    void numIslandsWithArrayOfMultipleElementsSingleAdjacentNumbers_scenario1() {
        int result = n.numIslands(new char[][]{
                new char[] { '1', '1' }
        });
        int expectedResult = 1;

        assertEquals(expectedResult, result);
    }

    @Test
    void numIslandsWithArrayOfMultipleElementsSingleAdjacentNumbers_scenario2() {
        int result = n.numIslands(new char[][]{
                new char[] { '1', '1' },
                new char[] { '1', '1' },
                new char[] { '1', '1' }
        });
        int expectedResult = 1;

        assertEquals(expectedResult, result);
    }

    @Test
    void numIslandsWithArrayOfMultipleElementsSingleAdjacentNumbers_scenario3() {
        int result = n.numIslands(new char[][]{
                new char[] { '1', '1', '1' },
                new char[] { '1', '1', '1' },
                new char[] { '1', '1' }
        });
        int expectedResult = 1;

        assertEquals(expectedResult, result);
    }

    @Test
    void numIslandsWithArrayOfMultipleElementsSingleAdjacentNumbers_scenario4() {
        int result = n.numIslands(new char[][]{
                new char[] { '1' },
                new char[] { '1' },
                new char[] { '1' },
                new char[] { '1' }
        });
        int expectedResult = 1;

        assertEquals(expectedResult, result);
    }

    @Test
    void numIslandsWithArrayOfMultipleIslands_scenario1() {
        int result = n.numIslands(new char[][]{
                new char[] { '1', '0', '1' },
                new char[] { '1', '0', '0' },
                new char[] { '1', '0', '1' },
                new char[] { '1', '0', '1' }
        });
        int expectedResult = 3;

        assertEquals(expectedResult, result);
    }

    @Test
    void numIslandsWithArrayOfMultipleIslands_scenario2() {
        int result = n.numIslands(new char[][]{
                new char[] { '1', '0', '1' },
                new char[] { '1', '1', '0' },
                new char[] { '1', '0', '1' },
                new char[] { '1', '0', '1' }
        });
        int expectedResult = 3;

        assertEquals(expectedResult, result);
    }

    @Test
    void numIslandsWithArrayOfMultipleIslands_scenario3() {
        int result = n.numIslands(new char[][]{
                new char[] { '1', '0', '1' },
                new char[] { '1', '1', '0' },
                new char[] { '1', '0', '0' },
                new char[] { '1', '0', '1' }
        });
        int expectedResult = 3;

        assertEquals(expectedResult, result);
    }
}