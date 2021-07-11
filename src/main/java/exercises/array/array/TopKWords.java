package exercises.array.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopKWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Long> frequency = Arrays.stream(words)
                .collect( Collectors.groupingBy( Function.identity(), Collectors.counting()));

        Comparator<Map.Entry<String, Long>> comparator = (a, b) -> -a.getValue().compareTo( b.getValue() );
        Comparator<Map.Entry<String, Long>> comparatorWithString = comparator.thenComparing( Map.Entry::getKey );

        return frequency.entrySet().stream()
                .sorted( comparatorWithString )
                .limit( k )
                .map( Map.Entry::getKey )
                .collect( Collectors.toList());
    }
}
