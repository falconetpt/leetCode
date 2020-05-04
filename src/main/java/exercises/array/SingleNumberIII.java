package exercises.array;

import java.util.ArrayList;
import java.util.HashSet;

public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        return singleNumber( nums, 0, new HashSet<>(  ), new ArrayList<>() );
    }

    private int[] singleNumber(int[] nums, int i, HashSet<Integer> seen, ArrayList<Integer> result) {
        if (i >= nums.length) {
            return result.stream().mapToInt( v -> v ).toArray();
        } else {
            Integer value = nums[i];
            if (seen.contains( value )) {
                result.remove( value );
            } else {
                seen.add( value );
                result.add( value );
            }
            return singleNumber( nums, i+1, seen, result );
        }
    }
}
