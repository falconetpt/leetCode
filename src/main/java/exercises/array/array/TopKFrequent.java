package exercises.array.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
