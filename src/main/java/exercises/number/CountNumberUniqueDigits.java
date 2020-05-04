package exercises.number;

public class CountNumberUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        } else {
            return 9 * countNumbersWithUniqueDigits( n -1, 9 );
        }

    }

    private int countNumbersWithUniqueDigits(int remaining, int multiplier) {
        if(remaining == 0) {
            return 1;
        } else {
            return multiplier * countNumbersWithUniqueDigits( remaining-1, multiplier-1 );
        }
    }

    /**
     * https://leetcode.com/problems/count-numbers-with-unique-digits/
     *
     * Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.
     *
     * Example:
     *
     * Input: 2
     * Output: 91
     * Explanation: The answer should be the total numbers in the range of 0 ≤ x < 100,
     *              excluding 11,22,33,44,55,66,77,88,99
     *
     */
}
