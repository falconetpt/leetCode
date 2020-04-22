package exercises.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SurroundedAreasTest {

    private SurroundedAreas s;

    @BeforeEach
    void init() {
        s = new SurroundedAreas();
    }

    @Test
    void solveEmptyBoard() {
        char[][] board = new char[][] { };

        char[][] expectedResult = new char[][] { };

        s.solve(board);

        assertArrayEquals(expectedResult, board);
    }

    @Test
    void solveAllXBoard() {
        char[][] board = new char[][] {
                new char[] { 'X', 'X' },
                new char[] { 'X', 'X' },
        };

        char[][] expectedResult = new char[][] {
                new char[] { 'X', 'X' },
                new char[] { 'X', 'X' },
        };

        s.solve(board);

        assertArrayEquals(expectedResult, board);
    }

    @Test
    void solveAllOBoard() {
        char[][] board = new char[][] {
                new char[] { 'O', 'O' },
                new char[] { 'O', 'O' },
        };

        char[][] expectedResult = new char[][] {
                new char[] { 'O', 'O' },
                new char[] { 'O', 'O' },
        };

        s.solve(board);

        assertArrayEquals(expectedResult, board);
    }


    @Test
    void solveBoardWithElementOInTheEdje() {
        char[][] board = new char[][] {
                new char[] { 'O', 'X' },
                new char[] { 'X', 'X' },
        };

        char[][] expectedResult = new char[][] {
                new char[] { 'O', 'X' },
                new char[] { 'X', 'X' },
        };

        s.solve(board);

        assertArrayEquals(expectedResult, board);
    }

    @Test
    void solveBoardWithCenterO() {
        char[][] board = new char[][] {
                new char[] { 'X', 'X', 'X' },
                new char[] { 'X', 'O', 'X' },
                new char[] { 'X', 'X', 'X' },
        };

        char[][] expectedResult = new char[][] {
                new char[] { 'X', 'X', 'X' },
                new char[] { 'X', 'X', 'X' },
                new char[] { 'X', 'X', 'X' },
        };

        s.solve(board);

        assertArrayEquals(expectedResult, board);
    }

    @Test
    void solveBoardWithMultipleOs() {
        char[][] board = new char[][] {
                new char[] { 'X', 'X', 'X', 'X' },
                new char[] { 'X', 'O', 'O', 'X' },
                new char[] { 'X', 'X', 'O', 'X' },
                new char[] { 'X', 'O', 'X', 'X' },
        };

        char[][] expectedResult = new char[][] {
                new char[] { 'X', 'X', 'X', 'X' },
                new char[] { 'X', 'X', 'X', 'X' },
                new char[] { 'X', 'X', 'X', 'X' },
                new char[] { 'X', 'O', 'X', 'X' },
        };

        s.solve(board);

        assertArrayEquals(expectedResult, board);
    }

    @Test
    void solveBoardWithMultiple0s_2() {

        char[][] board = new char[][] {
                new char[] { 'O','X','X','O','X' },
                new char[] { 'X','O','O','X','O' },
                new char[] { 'X','O','X','O','X' },
                new char[] { 'O','X','O','O','O' },
                new char[] { 'X','X','O','X','O' },
        };

        char[][] expectedResult = new char[][] {
                new char[] { 'O','X','X','O','X' },
                new char[] { 'X','X','X','X','O' },
                new char[] { 'X','X','X','O','X' },
                new char[] { 'O','X','O','O','O' },
                new char[] { 'X','X','O','X','O' },
        };

        s.solve(board);

        assertArrayEquals(expectedResult, board);
    }

    @Test
    void solveBoardWithMultiple0s_3() {

        char[][] board = new char[][] {
                {'X','O','X','O','X','O'},
                {'O','X','O','X','O','X'},
                {'X','O','X','O','X','O'},
                {'O','X','O','X','O','X'}
        };

        char[][] expectedResult = new char[][] {
                {'X','O','X','O','X','O'},
                {'O','X','X','X','X','X'},
                {'X','X','X','X','X','O'},
                {'O','X','O','X','O','X'}
        };

        s.solve(board);

        assertArrayEquals(expectedResult, board);
    }
}