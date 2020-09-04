package exercises.string;

public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(final String s) {
        int size = s.length();
        return repeatedSubstringPattern( s, 0, size, "" );
    }

    public boolean repeatedSubstringPattern(final String s, final int index,
                                            final int size, final String substring) {
        if (index >= size - 1) {
            return false;
        } else {
            String newString = substring + s.charAt( index );

            return (size % newString.length() == 0 && s.split( newString ).length == 0)
                    || repeatedSubstringPattern( s, index + 1, size, newString );
        }
    }
}
