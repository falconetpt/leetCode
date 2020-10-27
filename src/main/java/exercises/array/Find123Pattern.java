package exercises.array;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Find123Pattern {
    public boolean find132pattern(int[] nums) {
        final TreeMap<Integer, TreeSet<Integer>> treeMap = new TreeMap<>();
        IntStream.range( 0, nums.length )
                .peek( i -> treeMap.putIfAbsent( nums[i], new TreeSet<>(  ) ) )
                .forEach( i -> treeMap.get( nums[i] ).add( i ) );

        for (int i = 0; i < nums.length; i++) {
            final int first = i;
            Stream<Integer> jResult = treeMap.tailMap( nums[i] ).values()
                    .stream()
                    .map( j -> j.ceiling( first )  )
                    .filter( Objects::nonNull );
            Optional<Integer> last = jResult
                    .filter( k -> !treeMap.headMap( nums[k] ).isEmpty() )
                    .flatMap( k -> treeMap.headMap( nums[k] ).values()
                            .stream()
                            .map( l -> l.ceiling( k ) ) )
                    .filter( Objects::nonNull )
                    .findFirst();

            if (last.isPresent()) return true;
        }


        return false;

//        i, j, k
//        nums[i] < nums[k] && nums[k] < nums[j]

    }
}
