package exercises.array;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MajorityElement3 {
    public List<Integer> majorityElement(int[] nums) {
        final int length = nums.length / 3;

        final Map<Integer, Long> frequency = Arrays.stream(nums).boxed()
                .collect( Collectors.groupingBy( Function.identity(), Collectors.counting() ) );

        return frequency.entrySet().stream()
                .filter( e -> e.getValue() > length )
                .map( Map.Entry::getKey )
                .collect( Collectors.toList());
    }
}
