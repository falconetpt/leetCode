package exercises.string;

import java.util.Arrays;

public class ReverseString {
    public String reverseWords(String s) {
        return Arrays.stream(s.trim().split( "\\s+" )).map( String::trim )
                .reduce( "", (a, b) -> b + " " + a )
                .trim();
    }
}
