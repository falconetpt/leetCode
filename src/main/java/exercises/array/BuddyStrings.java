package exercises.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BuddyStrings {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        } else if (A.equals( B ) && Arrays
                .stream( A.split( "" ))
                .collect( Collectors.groupingBy( Function.identity(), Collectors.counting() ) )
                .values()
                .stream()
                .anyMatch( v -> v > 1 )
        ) {
            return true;
        } else {
            return buddyStrings( A, B, new Character[2], 0, true );
        }
    }

    private boolean buddyStrings(String a, String b, Character[] values, int i, boolean notSeen) {
        if (i >= a.length()) {
            return !notSeen;
        } else {
            char first = a.charAt( i );
            char second = b.charAt( i );

            if (first != second) {
                if (values[0] != null) {
                    if (values[0] == second && values[1] == first && notSeen) {
                        return buddyStrings( a, b, values, i + 1, false );
                    } else {
                        return false;
                    }
                } else {
                    values[0] = first;
                    values[1] = second;
                    return buddyStrings( a, b, values, i + 1, notSeen );
                }
            } else {
                return buddyStrings( a, b, values, i + 1, notSeen );
            }
        }
    }
}
