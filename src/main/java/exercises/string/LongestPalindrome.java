package exercises.string;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        } else {
            Map<String, Long> frequency = Arrays.stream(s.split( "" ))
                    .collect( Collectors.groupingBy( Function.identity(), Collectors.counting()));
            int totalValue = frequency.values().stream()
                    .reduce( 0L, Long::sum )
                    .intValue();
            return longestPalindrome( frequency, totalValue);
        }
    }

    public int longestPalindrome(final Map<String, Long> map,
                                 final int totalFound) {
        int total = map.values().stream()
                .map( i -> i / 2 )
                .reduce( 0L, Long::sum )
                .intValue() * 2;

        return Math.min( 1, totalFound - total ) + total;
    }
}
