package exercises.sort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomSortStringTest {
    private CustomSortString c;

    @BeforeEach
    void init() {
        c = new CustomSortString();
    }

    @Test
    void emptyStringShouldReturnEmpty() {
        String result = c.customSortString("", "");
        String expected = "";

        assertEquals(expected, result);
    }

    @Test
    void emptyStringShouldReturnSameIfTheElementsAreEqual() {
        String result = c.customSortString("a", "a");
        String expected = "a";

        assertEquals(expected, result);
    }

    @Test
    void shouldSortMultipleElement() {
        String result = c.customSortString("cba", "abcd");
        String expected = "cbad";

        assertEquals(expected, result);
    }

}