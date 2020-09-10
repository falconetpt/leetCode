package exercises.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OverlappingMatrixTest {

    private OverlappingMatrix overlappingMatrix = new OverlappingMatrix();

    @Test
    void largestOverlap() {
        int[][] matrixA = new int[][] { {1,1,0}, {0,1,0}, {0,1,0} };
        int[][] matrixB = new int[][] { {0,0,0}, {0,1,1}, {0,0,1} };

        int x = overlappingMatrix.largestOverlap( matrixA, matrixB );
        System.out.println(x);
    }

    @Test
    void largestOverlap2() {
        int[][] matrixA = new int[][] { {1} };
        int[][] matrixB = new int[][] { {1} };

        int x = overlappingMatrix.largestOverlap( matrixA, matrixB );
        System.out.println(x);
    }

    @Test
    void largestOverlap3() {
        int[][] matrixA = new int[][] { {1} };
        int[][] matrixB = new int[][] { {0} };

        int x = overlappingMatrix.largestOverlap( matrixA, matrixB );
        System.out.println(x);
    }

    @Test
    void largestOverlap4() {
        int[][] matrixA = new int[][] { { 0, 1 }, { 1, 1 } };
        int[][] matrixB = new int[][] { {1, 1}, {1, 1} };

        int x = overlappingMatrix.largestOverlap( matrixA, matrixB );
        System.out.println(x);
    }
}