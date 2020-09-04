package exercises.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StreamCheckerTest {

    @Test
    void query() {
        StreamChecker streamChecker = new StreamChecker( new String[]{"ab","ba","aaab","abab","baa"} );

        boolean result = streamChecker.query( 'a' );
        assertTrue( result );
    }
}