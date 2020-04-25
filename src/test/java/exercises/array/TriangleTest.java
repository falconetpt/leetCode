package exercises.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {
    private Triangle t;

    @BeforeEach
    void init() {
        t = new Triangle();
    }

    @Test
    @DisplayName( "Scenario 1 - Empty triangle should return 0" )
    void test1() {
        int expectedResult = 0;

        List<List<Integer>> subject = new ArrayList<>(  );
        int result = t.minimumTotal( subject );

        assertEquals( expectedResult, result );
    }

    @Test
    @DisplayName( "Scenario 2 - Empty triangle should return 0" )
    void test2() {
        int expectedResult = 0;

        List<List<Integer>> subject = new ArrayList<>(  );
        subject.add( new ArrayList<>(  ) );
        int result = t.minimumTotal( subject );

        assertEquals( expectedResult, result );
    }

    @Test
    @DisplayName( "Scenario 3 - Triangle with single element should return element" )
    void test3() {
        int expectedResult = 6;

        List<List<Integer>> subject = new ArrayList<>(  );
        subject.add( Stream.of( 6 ).collect( Collectors.toList()) );
        int result = t.minimumTotal( subject );

        assertEquals( expectedResult, result );
    }

    @Test
    @DisplayName( "Scenario 4 - Triangle with multiple elements should return smallest path" )
    void test4() {
        int expectedResult = 11;

        List<List<Integer>> subject = new ArrayList<>(  );
        subject.add( Stream.of(    2 ).collect( Collectors.toList()) );
        subject.add( Stream.of(   3, 4 ).collect( Collectors.toList()) );
        subject.add( Stream.of(  6, 5, 7 ).collect( Collectors.toList()) );
        subject.add( Stream.of( 4, 1, 8, 3 ).collect( Collectors.toList()) );


        int result = t.minimumTotal( subject );

        assertEquals( expectedResult, result );
    }
}