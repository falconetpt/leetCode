package exercises.array;

import java.util.ArrayList;
import java.util.List;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        return plusOne( digits, digits.length - 1, new ArrayList<>(  ), 0 );
    }

    public int[] plusOne(int[] digits, int index, List<Integer> result, int carry) {
        if (index < 0) {
            if (carry > 0) result.add( 0, carry );
            return result.stream().mapToInt(i->i).toArray();
        } else {
            int valuePlusOne = digits[index] + carry;
            int newValue = valuePlusOne % 10;
            int newCarry = valuePlusOne / 10;

            result.add( 0, newValue );

            return plusOne( digits, index - 1, result, newCarry );
        }
    }
}
