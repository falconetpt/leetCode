package exercises.array;

import java.util.ArrayList;
import java.util.List;

public class SumaryRange {
    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>(  );
        } else {
            return summaryRanges( nums, nums[0], nums[0], 1, new ArrayList<String>(  ) );
        }
    }

    private List<String> summaryRanges(int[] nums,
                                       int start,
                                       int end,
                                       int i,
                                       ArrayList<String> result) {
        if (i >= nums.length) {
            if (end == start) result.add( String.valueOf( start ) ); else result.add( start + "->" + end );
            return result;
        } else {
            int newNumber = nums[i];
            if (newNumber == end + 1) {
                return summaryRanges( nums, start, newNumber, i + 1, result );
            } else {
                if (end == start) result.add( String.valueOf( start ) ); else result.add( start + "->" + end );
                return summaryRanges( nums, newNumber, newNumber, i + 1, result );
            }
        }
    }
}
