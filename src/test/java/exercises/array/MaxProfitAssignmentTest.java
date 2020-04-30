package exercises.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxProfitAssignmentTest {

    @Test
    void maxProfitAssignment() {
        int maxProfit = new MaxProfitAssignment().maxProfitAssignment(
                    new int[] { 2,4,6,8,10 },
                    new int[] { 10,20,30,40,50 },
                    new int[] { 4,5,6,7 }
                );
        int expected = 100;

        assertEquals( expected, maxProfit );
    }

    @Test
    void maxProfitAssignment2() {
        int maxProfit = new MaxProfitAssignment().maxProfitAssignment(
                new int[] { 68,35,52,47,86 },
                new int[] { 67,17,1,81,3 },
                new int[] { 92,10,85,84,82 }
        );
        int expected = 324;

        assertEquals( expected, maxProfit );
    }

    @Test
    void maxProfitAssignment3() {
        int maxProfit = new MaxProfitAssignment().maxProfitAssignment(
                new int[] { 2,17,19,20,24,29,33,43,50,51,57,67,70,72,73,75,80,82,87,90 },
                new int[] { 6,7,10,17,18,29,30,31,34,39,40,42,48,54,57,78,78,78,83,88 },
                new int[] { 12,9,11,41,11,87,48,6,48,93,76,73,7,50,55,97,47,33,46,10 }
        );

        int expected = 693;

        assertEquals( expected, maxProfit );
    }

}