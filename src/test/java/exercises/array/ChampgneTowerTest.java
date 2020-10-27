package exercises.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChampgneTowerTest {

    @Test
    public void test () {
        double x = new ChampgneTower().champagneTower( 2, 1, 1 );
        assertEquals(0.5, x);
    }
}