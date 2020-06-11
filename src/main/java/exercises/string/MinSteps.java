package exercises.string;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MinSteps {
    public int minSteps(String s, String t) {
        Map<String, Long> sFrquency = Arrays.stream(s.split( "" ))
                .collect( Collectors.groupingBy( Function.identity(), Collectors.counting() ) );
        Map<String, Long> tFrquency = Arrays.stream(t.split( "" ))
                .collect( Collectors.groupingBy( Function.identity(), Collectors.counting() ) );

        return sFrquency.keySet().stream()
                .map( k -> (int) Math.max(sFrquency.getOrDefault( k, 0L ) - tFrquency.getOrDefault( k, 0L ), 0 ))
                .reduce( 0, Integer::sum );
    }
}
