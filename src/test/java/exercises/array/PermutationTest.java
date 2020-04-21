package exercises.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PermutationTest {
    private Permutation p;

    @BeforeEach
    void init() {
        p = new Permutation();
    }

    @Test
    void emptyList() {
        List<List<Integer>> result = p.permute( new int[] {} );
        List<List<Integer>> expectedResult = Stream.of(
                new ArrayList<Integer>(  )
        ).collect( Collectors.toList() );

        assertEquals( expectedResult, result );

    }

    @Test
    void SingleElementShouldReturnElement() {
        List<List<Integer>> result = p.permute( new int[] { 1 } );
        List<List<Integer>> expectedResult = Stream.of(
                Stream.of( 1 ).collect( Collectors.toList() )
        ).collect( Collectors.toList() );

        assertEquals( expectedResult, result );

    }

    @Test
    void multipleElementsShouldReturnNFactorialCombos_scenario1() {
        List<List<Integer>> result = p.permute( new int[] { 1, 2 } );
        List<List<Integer>> expectedResult = Stream.of(
                Stream.of( 1, 2 ).collect( Collectors.toList() ),
                Stream.of( 2, 1 ).collect( Collectors.toList() )
        ).collect( Collectors.toList() );

        assertEquals( expectedResult, result );

    }
}