package exercises.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        } else {
            Map<String, Long> frequency = Arrays.stream(s1.split( "" ))
                    .collect( Collectors.groupingBy( Function.identity(), Collectors.counting()));

            for (int i = 0; i < s2.length(); i++) {
                Map<String, Long> subset = new HashMap<>(  );
                for (int j = i; j < i + s1.length(); j++) {
                    String toAdd = String.valueOf( s2.charAt( j ) );
                    subset.put( toAdd, subset.getOrDefault( toAdd, 0L ) + 1 );
                }

                if (frequency.keySet().stream().allMatch( k -> frequency.get( k ) == subset.getOrDefault( k, 0L ) )) {
                    return true;
                }
            }

            return false;
        }
    }
}
