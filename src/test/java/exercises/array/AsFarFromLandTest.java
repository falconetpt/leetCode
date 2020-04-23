package exercises.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AsFarFromLandTest {
    private AsFarFromLand a;

    @BeforeEach
    void init() {
        a = new AsFarFromLand();
    }

    @Test
    @DisplayName("Scenario1 | Test1: Empty grid should return 0")
    void emptyGrid_test1() {
        int result = a.maxDistance(new int[][]{});
        int expected = 0;

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Scenario1 | Test2: Empty grid should return 0")
    void emptyGrid_test2() {
        int result = a.maxDistance(new int[][]{
                {}
        });
        int expected = 0;

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Scenario2 | Test1: Grid with all water")
    void gridWithAllZeroes_test1() {
        int result = a.maxDistance(new int[][]{
                {0}
        });
        int expected = 0;

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Scenario2 | Test2: Grid with all water")
    void gridWithAllZeroes_test2() {
        int result = a.maxDistance(new int[][]{
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        });
        int expected = 0;

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Scenario4 | Test1: Grid with Single land")
    void gridWithSingleLand_test1() {
        int result = a.maxDistance(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        });
        int expected = 2;

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Scenario5 | Test1: Grid with multiple lands")
    void gridWithMultipleLands_test1() {
        int result = a.maxDistance(new int[][]{
                { 1,0,1 },
                { 0,0,0 },
                { 1,0,1 }
        });
        int expected = 2;

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Scenario5 | Test2: Grid with multiple lands")
    void gridWithMultipleLands_test2() {
        int result = a.maxDistance(new int[][]{
                { 1,0,0 },
                { 0,0,0 },
                { 0,0,0 }
        });
        int expected = 4;

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Scenario5 | Test2: Grid with multiple lands")
    void gridWithMultipleLands_test3() {
        int result = a.maxDistance(new int[][]{
                { 1,0,1 },
                { 0,0,0 },
                { 1,0,1 }
        });
        int expected = 2;

        assertEquals(expected, result);
    }
}