package exercises.array;

import java.util.HashMap;
import java.util.Map;

public class CountBits {
    public int[] countBits(int num) {
        return countBits(num,  new HashMap<>() );
    }

    private int[] countBits(int maxNum, Map<Integer, Integer> cache) {
        int[] result = new int[maxNum + 1];
        cache.put( 0, 0 );

        for (int i = 0; i <= maxNum; i++) {
            result[i] = countOneBits(i, cache);
        }

        return result;
    }

    private int countOneBits(int num, Map<Integer, Integer> cache) {
        if (cache.containsKey( num )) {
            return cache.get( num );
        } else {
            int result = num % 2 + countOneBits( num/2, cache );
            cache.put( num, result );
            return result;
        }
    }
}
