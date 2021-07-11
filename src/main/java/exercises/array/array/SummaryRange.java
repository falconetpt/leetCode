package exercises.array.array;


import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class SummaryRange {
    public List<String> summaryRanges(int[] nums) {
        if (Optional.ofNullable(nums).map( n -> n.length == 0 ).orElse( false )) {
            return Collections.emptyList();
        } else {
            Point range = new Point( nums[0], nums[0] );
            List<String> result = new ArrayList<>(  );

            Function<Point, String> convert = (p) -> p.x == p.y
                    ? String.valueOf(p.x)
                    : p.x + "->" + p.y;

            return summaryRanges( nums, 1, range, result, convert );
        }
    }

    private List<String> summaryRanges(int[] nums,
                                       int i,
                                       Point range,
                                       List<String> result,
                                       Function<Point, String> convert) {
        if (i >= nums.length) {
            result.add( convert.apply( range ) );
            return result;
        } else {
            int value = nums[i];

            if (value - 1 > range.y) {
                result.add( convert.apply( range ) );
                return summaryRanges( nums, i + 1, new Point( value, value ), result, convert );
            } else {
                range.y = value;
                return summaryRanges( nums, i + 1, range, result, convert );
            }
        }
    }
}
