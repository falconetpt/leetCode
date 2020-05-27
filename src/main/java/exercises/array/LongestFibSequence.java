package exercises.array;

import java.util.*;
import java.util.stream.Collectors;

public class LongestFibSequence {
    public int lenLongestFibSubseq(int[] A) {
        TreeSet<Integer> numbers = Arrays.stream(A).boxed()
                .collect( Collectors.toCollection( TreeSet::new ));
        return lenLongestFibSubseq( numbers, 0 );
    }

    private int lenLongestFibSubseq(TreeSet<Integer> numbers, int result) {
        if (result >= numbers.size()) {
            return result;
        } else  {
            int number = numbers.pollFirst();
            int count = 2;

            for (Integer value : numbers) {
                int newValue = number + value;
                if (numbers.contains( newValue )) {
                    count = Math.max( count, 3 + calculateFibo( value, newValue, numbers ));
                }
            }

            return lenLongestFibSubseq( numbers, Math.max( count > 2 ? count : 0, result ) );
        }
    }

    private int calculateFibo(int first, int second, TreeSet<Integer> numbers) {
        if (numbers.contains( first + second )) {
            return 1 + calculateFibo( second, second + first, numbers );
        } else {
            return 0;
        }
    }
}
