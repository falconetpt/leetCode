package exercises.string;

import java.util.Arrays;

public class RemoveDuplicateStrings {

    public String removeDuplicateLetters(String s) {
        return Arrays.stream(s.split( "" ))
                .sorted()
                .distinct()
                .reduce( "", String::concat );
    }
}
