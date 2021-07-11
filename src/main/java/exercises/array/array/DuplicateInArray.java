package exercises.array.array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DuplicateInArray {
    public List<Integer> findDuplicates(int[] nums) {
        int[] duplicates = new int[nums.length];
        Arrays.stream( nums )
                .forEach( i -> duplicates[i-1]++ );
        return IntStream.range(0,  duplicates.length ).boxed()
                .filter( i -> duplicates[i] > 1 )
                .map( i -> i + 1 )
                .collect( Collectors.toList() );
    }
}
