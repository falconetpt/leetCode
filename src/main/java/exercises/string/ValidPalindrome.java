package exercises.string;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        return isPalindrome( s.toLowerCase(), 0, new StringBuilder() );
    }

    public boolean isPalindrome( String s, int index, StringBuilder sb ) {
        if (index >= s.length()) {
            return sb.toString().equals( sb.reverse().toString() );
        } else {
            boolean isChar = String.valueOf( s.charAt( index )).matches( "[0-9a-z]" );

            if (isChar) sb.append( s.charAt( index ) );

            return isPalindrome( s, index + 1, sb );
        }
    }
}
