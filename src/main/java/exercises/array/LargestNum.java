package exercises.array;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNum {
    public String largestNumber(int[] nums) {

        if (Arrays.stream( nums ).allMatch( n -> n == 0 )) {
            return "0";
        } else {
            Comparator<String> order = (s1, s2) -> -(s1 + s2).compareTo( s2 + s1 );

            return Arrays.stream(nums).boxed()
                    .map( String::valueOf )
                    .sorted( order )
                    .reduce( "", String::concat );
        }
    }

}
