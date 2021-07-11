package exercises.array.array;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BalancedString {
    public int balancedString(String s) {
        Map<String, Long> frequencyMap = Arrays.stream(s.split( "" ))
                .collect( Collectors.groupingBy( Function.identity(), Collectors.counting()) );
        int expectedOccurences = s.length() / 4;

        return frequencyMap.values().stream()
                .filter( e -> e > expectedOccurences )
                .map( e -> e - expectedOccurences )
                .reduce( 0L, Long::sum).intValue();

        /**
         * Not complete, it was boring to do the other part, but essentially the idea is using this base
         *
         * Go through the string and find the min (largest, smallest) that can cope with the replacement
         */
    }
}
