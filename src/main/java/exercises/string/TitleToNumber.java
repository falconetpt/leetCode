package exercises.string;

public class TitleToNumber {
    public int titleToNumber(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        } else {
            return titleToNumber( s, s.length() - 1 );
        }
    }

    private int titleToNumber(final String s, int index) {
        if (index >= 0) {
            int value = s.charAt( index ) - 'A' + 1;
            return value + 26 * titleToNumber( s, index - 1 );
        } else {
            return 0;
        }
    }
}
