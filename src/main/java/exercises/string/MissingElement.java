package exercises.string;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MissingElement {
    public char findTheDifference(String s, String t) {
        Map<Character, Long> sFrequency = Arrays.stream(s.split(""))
                .filter( Objects::nonNull )
                .filter( str -> str.length() > 0 )
                .map( str -> str.charAt( 0 ) )
                .collect( Collectors.groupingBy( Function.identity(), Collectors.counting() ));

        Map<Character, Long> tFrequency = Arrays.stream(t.split(""))
                .filter( Objects::nonNull )
                .filter( str -> str.length() > 0 )
                .map( str -> str.charAt( 0 ) )
                .collect( Collectors.groupingBy( Function.identity(), Collectors.counting() ));


        return Stream.concat(sFrequency.keySet().stream(), tFrequency.keySet().stream())
                .filter( k -> !sFrequency.getOrDefault( k, 0L ).equals( tFrequency.getOrDefault( k, 0L ) ) )
                .findFirst()
                .orElse( ' ' );
    }
}
