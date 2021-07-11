package exercises.array.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Permutation {
    public List<List<Integer>> permute(int[] nums) {
        final Set<Integer> numbers = Arrays.stream( nums ).boxed().collect( Collectors.toSet());

        if (nums.length == 0) {
            return Stream.of( new ArrayList<Integer>(  ) ).collect( Collectors.toList() );
        } else {
            return generatePermutations(numbers, new ArrayList<>(), new ArrayList<>());
        }
    }

    private List<List<Integer>> generatePermutations(Set<Integer> numbers,
                                                     List<Integer> currentList,
                                                     List<List<Integer>> result) {
        if(numbers.isEmpty()) {
            result.add( currentList );
            return result;
        } else {
            for (Integer number: numbers) {
                Set<Integer> newSet = new HashSet<>( numbers );
                newSet.remove( number );
                List<Integer> newList = new LinkedList<>( currentList );
                newList.add( number );

                generatePermutations( newSet, newList, result );
            }

            return result;
        }
    }

    /**
     * https://leetcode.com/problems/permutations/
     *
     * Given a collection of distinct integers, return all possible permutations.
     *
     * Example:
     *
     * Input: [1,2,3]
     * Output:
     * [
     *   [1,2,3],
     *   [1,3,2],
     *   [2,1,3],
     *   [2,3,1],
     *   [3,1,2],
     *   [3,2,1]
     * ]
     *
     */
}
