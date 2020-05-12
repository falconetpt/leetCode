package exercises.array;

import org.junit.jupiter.api.Test;

class StraightHandTest {
    private StraightHand s = new StraightHand();

    @Test
    void isNStraightHand() {
        s.isNStraightHand( new int[] { 1,2,3,6,2,3,4,7,8 }, 3 );
    }
}