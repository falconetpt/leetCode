package exercises.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StrongPasswordCheckerTest {
    StrongPasswordChecker s = new StrongPasswordChecker();

    @Test
    void strongPasswordChecker() {
        assertEquals( 1,  s.strongPasswordChecker( "" ));
    }

    @Test
    void strongPasswordChecker2() {
        assertEquals( 1,  s.strongPasswordChecker( "aaaA1hdei" ));
    }

    @Test
    void strongPasswordChecker1() {
        assertEquals( 0,  s.strongPasswordChecker( "aA1hdei" ));
    }
}