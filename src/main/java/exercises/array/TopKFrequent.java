package exercises.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(  );

        Arrays.stream(nums).forEach( num -> {
            map.put( num, map.getOrDefault( num, 0 ) + 1);
        });

        return map.keySet().stream()
                .sorted( (a, b) -> -map.get( a ).compareTo( map.get( b ) ) )
                .limit( k )
                .mapToInt( i -> i )
                .toArray();
    }
}
