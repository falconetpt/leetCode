package exercises.array;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.IntStream;

public class NumSubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int prod = 1, ans = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) prod /= nums[left++];
            ans += right - left + 1;
        }
        return ans;
    }

//    MySolution:
//
//    public int numSubarrayProductLessThanK(int[] nums, int k) {
//        BigInteger[] forwardMult = Arrays.stream(nums).mapToObj( BigInteger::valueOf )
//                .toArray(BigInteger[]::new);
//
//        IntStream.range( 1, forwardMult.length )
//                .forEach( i -> forwardMult[i] = forwardMult[i].multiply( forwardMult[i-1] ) );
//
//        int count = 0;
//
//        for (int i = 0; i < nums.length; i++) {
//            BigInteger previousValue = i == 0 ? BigInteger.ONE : forwardMult[i-1];
//            count += countValue(forwardMult, i, previousValue, k);
//        }
//
//        return count;
//    }
//
//    private int countValue(BigInteger[] array, int index, BigInteger previousValue, int target) {
//        if (index >= array.length || array[index].divide( previousValue ).intValue() >= target) {
//            return 0;
//        } else {
//            return 1 + countValue( array, index + 1, previousValue, target ) ;
//        }
//    }
}
