package exercises.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnightProbabilityInChessBoardTest {
    private KnightProbabilityInChessBoard k;

    @BeforeEach
    void init() {
        k = new KnightProbabilityInChessBoard();
    }

    @Test
    void knightProbabilityWithNoHops_scenario1() {
        double result = k.knightProbability(25, 0, 0, 0);
        double expectedResult = 1;

        assertEquals(expectedResult, result);
    }

    @Test
    void knightProbabilityWithNoHops_scenario2() {
        double result = k.knightProbability(1, 0, 0, 0);
        double expectedResult = 1;

        assertEquals(expectedResult, result);
    }

    @Test
    void knightProbabilityWithNoHops_scenario3() {
        double result = k.knightProbability(1, 0, 1, 0);
        double expectedResult = 0;

        assertEquals(expectedResult, result);
    }

    @Test
    void knightProbabilityWithHopsInEmptyBoard() {
        double result = k.knightProbability(0, 2, 0, 0);
        double expectedResult = 0.0;

        assertEquals(expectedResult, result);
    }

    @Test
    void knightProbabilityWithHopsInSmallerBoard() {
        double result = k.knightProbability(1, 2, 0, 0);
        double expectedResult = 0.0;

        assertEquals(expectedResult, result);
    }

    @Test
    void knightProbabilityWithSingleHopInThreeSidedBoard_scenario1() {
        double result = k.knightProbability(3, 1, 0, 0);
        double expectedResult = 2/8.0;

        assertEquals(expectedResult, result);
    }

    @Test
    void knightProbabilityWithSingleHopInThreeSidedBoard_scenario2() {
        double result = k.knightProbability(3, 1, 2, 1);
        double expectedResult = 2/8.0;

        assertEquals(expectedResult, result);
    }

    @Test
    void knightProbabilityWithSingleHopInThreeSidedBoard_scenario3() {
        double result = k.knightProbability(3, 1, 1, 2);
        double expectedResult = 2/8.0;

        assertEquals(expectedResult, result);
    }

    @Test
    void knightProbabilityWithDoubleHopInThreeSidedBoard_scenario1() {
        double result = k.knightProbability(3, 2, 1, 2);
        double expectedResult = 0.0625;

        assertEquals(expectedResult, result);
    }

    @Test
    void knightProbabilityWithDoubleHopInThreeSidedBoard_scenario2() {
        double result = k.knightProbability(3, 3, 0, 0);
        double expectedResult = 0.01562;

        assertEquals(expectedResult, result, 0.0005);
    }

    @Test
    void knightProbabilityWithDoubleHopInThreeSidedBoard_scenario3() {
//        double result = k.knightProbability(8,30,6,4);
//        double expectedResult = 0.00019;
//
//        System.out.println(result);
//
//        assertEquals(expectedResult, result, 0.0005);
    }
}