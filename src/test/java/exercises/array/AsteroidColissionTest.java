package exercises.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class AsteroidColissionTest {
    private AsteroidColission a;

    @BeforeEach
    void setUp() {
        a = new AsteroidColission();
    }

    @Test
    @DisplayName( "Empty Array should return same array" )
    void test1() {
        int[] result = a.asteroidCollision( new int[] {} );
        int[] expected = new int[] {};

        assertArrayEquals( expected, result );
    }

    @Test
    @DisplayName( "Single element should return same array" )
    void test2() {
        int[] result = a.asteroidCollision( new int[] { 2 } );
        int[] expected = new int[] { 2 };

        assertArrayEquals( expected, result );
    }

    @Test
    @DisplayName( "Element Pair should return array" )
    void test3() {
        int[] result = a.asteroidCollision( new int[] { -2, 2 } );
        int[] expected = new int[] { -2, 2 };

        assertArrayEquals( expected, result );
    }

    @Test
    @DisplayName( "Element Pair colliding should return empty array" )
    void test4() {
        int[] result = a.asteroidCollision( new int[] { 2, -2 } );
        int[] expected = new int[] { };

        assertArrayEquals( expected, result );
    }

    @Test
    @DisplayName( "Element Pair colliding should return empty array" )
    void test5() {
        int[] result = a.asteroidCollision( new int[] { 8, -8 } );
        int[] expected = new int[] { };

        assertArrayEquals( expected, result );
    }

    @Test
    @DisplayName( "Multiple elements colliding with bigger element should return empty bigger element" )
    void test6() {
        int[] result = a.asteroidCollision( new int[] { 2, 4, -8 } );
        int[] expected = new int[] { -8 };

        assertArrayEquals( expected, result );
    }

    @Test
    @DisplayName( "Element Pair colliding with bigger element should return empty bigger element" )
    void test7() {
        int[] result = a.asteroidCollision( new int[] { 5, 10, -5 } );
        int[] expected = new int[] { 5, 10 };

        assertArrayEquals( expected, result );
    }

    @Test
    @DisplayName( "Element Pair colliding with bigger element should return empty bigger element" )
    void test8() {
        int[] result = a.asteroidCollision( new int[] { 5, 10, -5 } );
        int[] expected = new int[] { 5, 10 };

        assertArrayEquals( expected, result );
    }

    @Test
    @DisplayName( "Element Pair colliding with bigger element should return empty bigger element" )
    void test9() {
        int[] result = a.asteroidCollision( new int[] { 10, 2, -5 } );
        int[] expected = new int[] { 10 };

        assertArrayEquals( expected, result );
    }
}
