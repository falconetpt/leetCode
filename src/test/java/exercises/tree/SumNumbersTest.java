package exercises.tree;

import exercises.array.helper.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumNumbersTest {
    private SumNumbers s;

    @BeforeEach
    void init() {
        s = new SumNumbers();
    }

    @Test
    void sumNumbersWithNullRoot() {
        int result = s.sumNumbers( null );
        int expectedResult = 0;

        assertEquals( expectedResult, result );
    }

    @Test
    void sumNumbersWithOnlyRoot() {
        int result = s.sumNumbers( new TreeNode(12) );
        int expectedResult = 12;

        assertEquals( expectedResult, result );
    }

    @Test
    void sumNumbersWithTreeRoot() {
        TreeNode root = new TreeNode(12);
        root.setLeft( new TreeNode( 1 ) );
        root.setRight( new TreeNode( 10 ) );

        int result = s.sumNumbers( root );
        int expectedResult = 121 + 1210;

        assertEquals( expectedResult, result );
    }

    @Test
    void sumNumbersWithLargeTreeRoot() {
        TreeNode root = new TreeNode(4);
        TreeNode left = new TreeNode( 9 );
        TreeNode right = new TreeNode( 0 );

        left.setLeft( new TreeNode( 5 ) );
        left.setRight( new TreeNode( 1 ) );

        root.setLeft( left );
        root.setRight( right );

        int result = s.sumNumbers( root );
        int expectedResult = 1026;

        assertEquals( expectedResult, result );
    }
}