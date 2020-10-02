package exercises.tree;

import exercises.array.helper.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BinaryTreePalindrome {
    public int pseudoPalindromicPaths (final TreeNode root) {
        List<char[]> paths = new ArrayList<>();

        generatePaths(root, "", paths );

        return (int) paths.stream().filter( this::pseudoPalindrome ).count();
    }

    private void generatePaths(final TreeNode node,
                               final String currentString,
                               final List<char[]> result) {
        if (node != null) {
            String newString = currentString + node.val;

            if(Stream.of(node.left, node.right).allMatch( Objects::isNull )) {
                result.add( newString.toCharArray() );
            }

            Stream.of( node.left, node.right ).forEach( n -> generatePaths( n, newString, result ) );
        }
    }

    private boolean pseudoPalindrome(final char[] s) {
        return IntStream.range( 0, s.length ).anyMatch(
                x -> IntStream.range(x + 1, s.length)
                        .anyMatch( y -> {
                            char tmp = s[x];
                            s[x] = s[y];
                            s[y] = tmp;

                            String str = String.valueOf(s);

                            boolean result = new StringBuilder( str ).reverse().toString().equals( str );
                            s[y] = s[x];
                            s[x] = tmp;
                            return result;
                        } )
        );
    }
}
