package exercises.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PartitionDisjointTest {

    @Test
    void partitionDisjoint_test1() {
        int result = new PartitionDisjoint().partitionDisjoint( new int[] { 5,0,3,8,6 } );
        int expectedResult = 3;

        assertEquals( expectedResult, result );
    }

    @Test
    void partitionDisjoint_test2() {
        int result = new PartitionDisjoint().partitionDisjoint( new int[] { 1,1,1,0,6,12 } );
        int expectedResult = 4;

        assertEquals( expectedResult, result );
    }

    @Test
    void partitionDisjoint_test3() {
        int result = new PartitionDisjoint().partitionDisjoint( new int[] { 32,57,24,19,0,24,49,67,87,87 } );
        int expectedResult = 7;

        assertEquals( expectedResult, result );
    }
}