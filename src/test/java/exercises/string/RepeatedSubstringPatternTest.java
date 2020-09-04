package exercises.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepeatedSubstringPatternTest {

    @Test
    void repeatedSubstringPattern() {
        RepeatedSubstringPattern r = new RepeatedSubstringPattern();
        assertTrue( r.repeatedSubstringPattern( "aba" ) );
    }
}