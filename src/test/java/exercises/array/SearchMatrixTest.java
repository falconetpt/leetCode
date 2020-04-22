package exercises.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchMatrixTest {
    private SearchMatrix s;

    @BeforeEach
    void init() {
        s = new SearchMatrix();
    }

    @Test
    @DisplayName("Scenario 1 | Test 1: Empty Matrix should always return false")
    void emptyMatrix_test1() {
        boolean result = s.searchMatrix(new int[][]{
        }, 7);
        boolean expectedResult = false;

        assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Scenario 1 | Test 2: Empty Matrix should always return false")
    void emptyMatrix_test2() {
        boolean result = s.searchMatrix(new int[][]{
                new int[] {}
        }, 1283761);
        boolean expectedResult = false;

        assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Scenario 2 | Test 1: Single Element Matrix with no match")
    void singleElement_test1() {
        boolean result = s.searchMatrix(new int[][]{
                new int[] { 2 }
        }, 3);
        boolean expectedResult = false;

        assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Scenario 2 | Test 2: Single Element Matrix with match")
    void singleElement_test2() {
        boolean result = s.searchMatrix(new int[][]{
                new int[] { 7 }
        }, 7);
        boolean expectedResult = true;

        assertEquals(expectedResult, result);
    }


    @Test
    @DisplayName("Scenario 3 | Test 1: Multiple Element Matrix with element in matrix")
    void multipleElements_test1() {
        boolean result = s.searchMatrix(new int[][]{
                new int[] { 1, 4, 7 },
                new int[] { 2, 5, 8 },
                new int[] { 3, 12, 15 },
        }, 8);
        boolean expectedResult = true;

        assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Scenario 3 | Test 2: Multiple Element Matrix with element in matrix")
    void multipleElements_test2() {
        boolean result = s.searchMatrix(new int[][]{
                new int[] { 1, 4, 7 },
                new int[] { 2, 5, 8 },
                new int[] { 3, 12, 15 },
        }, 15);
        boolean expectedResult = true;

        assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Scenario 3 | Test 3: Multiple Element Matrix with element in matrix")
    void multipleElements_test3() {
        boolean result = s.searchMatrix(new int[][]{
                new int[] { 1, 4, 7 },
                new int[] { 2, 5, 8 },
                new int[] { 3, 12, 15 },
        }, 3);
        boolean expectedResult = true;

        assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Scenario 3 | Test 4: Multiple Element Matrix with element in matrix")
    void multipleElements_test4() {
        boolean result = s.searchMatrix(new int[][]{
                new int[] { 1, 4, 7 },
                new int[] { 2, 5, 8 },
                new int[] { 3, 12, 15 },
        }, 1);
        boolean expectedResult = true;

        assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Scenario 3 | Test 5: Multiple Element Matrix with element not in matrix")
    void multipleElements_test5() {
        boolean result = s.searchMatrix(new int[][]{
                new int[] { 1, 4, 7 },
                new int[] { 2, 5, 8 },
                new int[] { 3, 12, 15 },
        }, 48);
        boolean expectedResult = false;

        assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Scenario 3 | Test 6: Multiple Element Matrix with element in matrix")
    void multipleElements_test6() {
        boolean result = s.searchMatrix(new int[][]{
                new int[] { 1, 4, 7 },
                new int[] { 2, 5, 8 },
                new int[] { 3, 12, 15 },
        }, 12);
        boolean expectedResult = true;

        assertEquals(expectedResult, result);
    }
    
    @Test
    @DisplayName("Scenario 3 | Test 7: Multiple Element Matrix with element in matrix")
    void multipleElements_test7() {
        boolean result = s.searchMatrix(new int[][] {
                {1,2,3,4,5},
                {6,7,8,9,10} ,
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}
        }, 15);
        boolean expectedResult = true;

        assertEquals(expectedResult, result);
    }
}