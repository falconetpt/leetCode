package exercises.string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GroupAnagramsTest {

    @Test
    @DisplayName("Scenario 1: Generic Scenario")
    void groupAnagrams() {
        List<List<String>> result = new GroupAnagrams()
                .groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"});
        List<List<String>> expected = Stream.of(
                Stream.of("eat","tea", "ate").collect(Collectors.toList()),
                Stream.of("bat").collect(Collectors.toList()),
                Stream.of("tan", "nat").collect(Collectors.toList())
        ).collect(Collectors.toList());

        assertEquals(expected, result);
    }
}