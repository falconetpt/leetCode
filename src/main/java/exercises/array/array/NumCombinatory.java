package exercises.array.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumCombinatory {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return combinationSum( candidates, target, "", new ArrayList<>(), 0 );
    }

    private List<List<Integer>> combinationSum(int[] candidates,
                                               int target,
                                               String s,
                                               List<List<Integer>> lists, int index) {
        if (target == 0 && s.length() > 0) {
            lists.add(
                    Arrays.stream(s.substring( 1 ).split( "," ))
                            .map( Integer::valueOf )
                            .collect( Collectors.toList())
            );
            return lists;
        } else {

            IntStream.range( index, candidates.length )
                    .filter( i -> target - candidates[i] >= 0 )
                    .forEach( i -> combinationSum( candidates, target - candidates[i], s + "," + candidates[i], lists, i ) );

            return lists;
        }
    }
}
