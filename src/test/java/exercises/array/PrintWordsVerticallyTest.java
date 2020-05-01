package exercises.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrintWordsVerticallyTest {
    PrintWordsVertically p = new PrintWordsVertically();

    @Test
    @DisplayName( "Empty String sould return empty list" )
    void test1() {
        List<String> result = p.printVertically( "" );
        List<String> expected = new ArrayList<>(  );

        assertEquals( expected, result );
    }

    @Test
    @DisplayName( "Null String sould return empty list" )
    void test2() {
        List<String> result = p.printVertically( null );
        List<String> expected = new ArrayList<>(  );

        assertEquals( expected, result );
    }

    @Test
    @DisplayName( "1 - Single word scenario" )
    void test3() {
        List<String> result = p.printVertically( "to" );
        List<String> expected = Arrays.asList( "t", "o" );

        assertEquals( expected, result );
    }

    @Test
    @DisplayName( "1 - Multiple words scenario" )
    void test4() {
        List<String> result = p.printVertically( "you are cool" );
        List<String> expected = Arrays.asList(
                "yac",
                "oro",
                "ueo",
                "  l"
                );

        assertEquals( expected, result );
    }

    @Test
    @DisplayName( "2 - Multiple words scenario" )
    void test5() {
        List<String> result = p.printVertically( "TO BE OR NOT TO BE" );
        List<String> expected = Arrays.asList(
                "TBONTB",
                "OEROOE",
                "   T"
                );

        assertEquals( expected, result );
    }
}