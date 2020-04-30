package exercises.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IncreasingTripletsTest {
    private IncreasingTriplets i = new IncreasingTriplets();

    @Test
    @DisplayName("Empty array should return false")
    void test1() {
        boolean result = i.increasingTriplet(new int[] { });
        boolean expected = false;

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Array with less than 3 element should return false")
    void test2() {
        boolean result = i.increasingTriplet(new int[] { });
        boolean expected = false;

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Array with 3 element should return true")
    void test3() {
        boolean result = i.increasingTriplet(new int[] { 1, 2, 3 });
        boolean expected = true;

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Array with multiple elements ascending should return true")
    void test4() {
        boolean result = i.increasingTriplet(new int[] { 4, 2, 1, 2, 3 });
        boolean expected = true;

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Array with multiple elements ascending but not three should return false")
    void test5() {
        boolean result = i.increasingTriplet(new int[] { 4, 2, 1, 5, 3 });
        boolean expected = false;

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Array with multiple elements ascending should return true")
    void test6() {
        boolean result = i.increasingTriplet(new int[] { 4, 2, 1, 5, 3, 6 });
        boolean expected = false;

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Array with multiple elements ascending should return true")
    void test7() {
        boolean result = i.increasingTriplet(new int[] { 2, 4, 2, 0, 2, 1, 0, 2, 1, 4, 2 });
        boolean expected = false;

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Array with multiple elements ascending should return true")
    void test8() {
        boolean result = i.increasingTriplet(new int[] { 2, 3, 4, 1 });
        boolean expected = true;

        assertEquals(expected, result);
    }
}