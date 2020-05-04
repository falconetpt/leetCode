package exercises.string;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RansomNoteTest {
    private RansomNote r;

    @BeforeEach
    void setUp() {
        r = new RansomNote();
    }

    @Test
    @DisplayName( "1 - Empty Ransom Note should return true always" )
    void test1() {
        boolean result = r.canConstruct( "", "wtvlaeradhsjk" );
        boolean expected = true;

        assertEquals( expected, result );
    }

    @Test
    @DisplayName( "2 - Empty magazine and ransomnote shoulr return true always" )
    void test2() {
        boolean result = r.canConstruct( "", "" );
        boolean expected = true;

        assertEquals( expected, result );
    }

    @Test
    @DisplayName( "3 - Any letter in ransom note and no magazine should return false" )
    void test3() {
        boolean result = r.canConstruct( "a", "" );
        boolean expected = false;

        assertEquals( expected, result );
    }

    @Test
    @DisplayName( "4 - Any letter in ransom note and different magazine letters  should return false" )
    void test4() {
        boolean result = r.canConstruct( "a", "b" );
        boolean expected = false;

        assertEquals( expected, result );
    }

    @Test
    @DisplayName( "5 - Any letter in ransom note and different magazine letters  should return false" )
    void test5() {
        boolean result = r.canConstruct( "aa", "ab" );
        boolean expected = false;

        assertEquals( expected, result );
    }

    @Test
    @DisplayName( "6 - Any letter in ransom note and equal number of magazine letters  should return true" )
    void test6() {
        boolean result = r.canConstruct( "aa", "aab" );
        boolean expected = true;

        assertEquals( expected, result );
    }
}