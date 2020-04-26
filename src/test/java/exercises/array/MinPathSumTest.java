package exercises.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinPathSumTest {
    private MinPathSum m = new MinPathSum();


    @Test
    @DisplayName( "" )
    void minPathSum() {
        int result = m.minPathSum(
                new int[][] {
                        {1,3,1},
                        {1,5,1},
                        {4,2,1}
                }
        );
        int expectedResult = 7;

        assertEquals( expectedResult, result );
    }
}