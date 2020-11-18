package exercises.array;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LargestMountainTest {
    @Test
    public void initTest() {
        int input = new LargestMountain()
                .longestMountain( new int[] { 0,1,2,3,4,5,4,3,2,1,0 } );
    }
}