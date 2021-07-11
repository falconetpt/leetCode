package exercises.array.array;

public class ReverseString {
    public void reverseString(char[] s) {
        if (s != null) {
            reverseString( s, 0, s.length-1 );
        }
    }

    private void reverseString(char[] s, int start, int end) {
        if (start < end) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
        }
    }
}
