package exercises.array;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SmallestRangeTest {
    private SmallestRange s = new SmallestRange();

    @Test
    void scenario1() {
        int[] result = s.smallestRange(Stream.of(
                Stream.of(4,10,15,24,26).collect(Collectors.toList()),
                Stream.of(0,9,12,20).collect(Collectors.toList()),
                Stream.of(5,18,22,30).collect(Collectors.toList())
        ).collect(Collectors.toCollection(ArrayList::new)));

        int[] expected = new int[] { 20, 24 };

        assertArrayEquals(expected, result);
    }

    @Test
    void scenario2() {
        int[] result = s.smallestRange(Stream.of(
                Stream.of(4).collect(Collectors.toList()),
                Stream.of(0).collect(Collectors.toList()),
                Stream.of(5).collect(Collectors.toList()),
                Stream.of(5).collect(Collectors.toList())
        ).collect(Collectors.toCollection(ArrayList::new)));

        int[] expected = new int[] { 0, 5 };

        assertArrayEquals(expected, result);
    }
}