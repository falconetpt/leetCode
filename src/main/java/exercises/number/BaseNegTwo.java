package exercises.number;

public class BaseNegTwo {
    public String baseNeg2(int N) {
        if (N == 0) {
            return "0";
        } else {
            return baseNeg2Rec( N );
        }
    }

    private String baseNeg2Rec(int num) {
        if (num == 0) {
            return "";
        } else {
            int remainder = num % -2;
            return remainder >= 0
                    ? baseNeg2Rec( num / -2 ) + remainder
                    : baseNeg2Rec( num / -2 + 1 ) + (remainder + 2);
        }
    }
}
