package exercises.tree;

import exercises.array.helper.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Documented;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FlipEquivalentBinaryTreeTest {
    private FlipEquivalentBinaryTree f;

    @BeforeEach
    void init() {
        f = new FlipEquivalentBinaryTree();
    }

    @Test
    @DisplayName( "Empty nodes should return true" )
    void emptyTreeShouldReturnTrue() {
        boolean result = f.flipEquiv( null, null );
        boolean expectedResult = true;

        assertEquals( expectedResult, result );
    }

    @Test
    @DisplayName( "Just one empty node should return false" )
    void oneEmptyNodeShouldReturnFalse() {
        assertEquals( false, f.flipEquiv( new TreeNode( 0 ), null ) );
        assertEquals( false, f.flipEquiv( null, new TreeNode( 3 ) ) );
    }

    @Test
    @DisplayName( "Root with different value should return false" )
    void rootWithDiferentValueShouldReturnFalse() {
        boolean result = f.flipEquiv( new TreeNode( 1 ), new TreeNode( 2 ) );
        boolean expectedResult = false;

        assertEquals( expectedResult, result );
    }


    @Test
    @DisplayName( "Flip is possible with simple swap value" )
    void flipIsPossibleWithSwap_scenario1() {
        TreeNode root1 = new TreeNode( 1 );
        TreeNode root2 = new TreeNode( 1 );

        root1.left = new TreeNode( 2 );
        root2.right = new TreeNode( 2 );

        boolean result = f.flipEquiv( root1, root2 );
        boolean expectedResult = true;

        assertEquals( expectedResult, result );
    }

    @Test
    @DisplayName( "Flip is not possible with simple swap value" )
    void flipIsNotPossibleWithSwap_scenario1() {
        TreeNode root1 = new TreeNode( 1 );
        TreeNode root2 = new TreeNode( 1 );

        root1.left = new TreeNode( 2 );
        root2.right = new TreeNode( 1 );

        boolean result = f.flipEquiv( root1, root2 );
        boolean expectedResult = false;

        assertEquals( expectedResult, result );
    }

    @Test
    @DisplayName( "Flip is possible with multiple swap value" )
    void flipIsPossibleWithMultipleSwap_scenario1() {
        TreeNode root1 = new TreeNode( 1 );
        TreeNode root2 = new TreeNode( 1 );
        TreeNode root1Child = new TreeNode( 2 );
        TreeNode root2Child = new TreeNode( 2 );
        TreeNode root1GrandChild = new TreeNode( 3 );
        TreeNode root2GrandChild = new TreeNode( 3 );

        root1Child.right = root1GrandChild;
        root2Child.left = root2GrandChild;

        root1.left = root1Child;
        root2.right = root2Child;

        boolean result = f.flipEquiv( root1, root2 );
        boolean expectedResult = true;

        assertEquals( expectedResult, result );
    }

    @Test
    @DisplayName( "Flip is not possible with multiple swap value" )
    void flipIsNotPossibleWithMultipleSwap_scenario1() {
        TreeNode root1 = new TreeNode( 1 );
        TreeNode root2 = new TreeNode( 1 );
        TreeNode root1Child = new TreeNode( 2 );
        TreeNode root2Child = new TreeNode( 2 );
        TreeNode root1GrandChild = new TreeNode( 3 );
        TreeNode root2GrandChild = new TreeNode( 4 );

        root1Child.right = root1GrandChild;
        root2Child.left = root2GrandChild;

        root1.left = root1Child;
        root2.right = root2Child;

        boolean result = f.flipEquiv( root1, root2 );
        boolean expectedResult = false;

        assertEquals( expectedResult, result );
    }
}