package exercises.string;

import java.util.Objects;

public class ValidUpperCase {
    public boolean detectCapitalUse(String word) {
        return Objects.isNull( word )
                || detectCapitalUse( word, 0, -1, 0 );
    }

    public boolean detectCapitalUse(String word, int index, int lasttUpperFound, int upperCount) {
        if (index >= word.length()) {
            return upperCount == 0 || upperCount == 1 || upperCount == word.length();
        } else {
            String value = String.valueOf( word.charAt( index ) );
            boolean isUpper = value.toUpperCase().equals( value );

            if (lasttUpperFound != -1) {
                return isUpper ? index -1 == lasttUpperFound && detectCapitalUse( word, index + 1, index, upperCount + 1) : detectCapitalUse( word, index + 1, lasttUpperFound, upperCount );
            } else {
                return isUpper
                        ? index == 0 && detectCapitalUse( word, index + 1, index, upperCount + 1 )
                        : detectCapitalUse( word, index + 1, -1, upperCount);
            }
        }
    }
}
