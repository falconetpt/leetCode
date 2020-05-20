package exercises.array;

public class GuessNumber {
    public int getMoneyAmount(int n) {
        return getMoneyAmount( 1, n );
    }

    private int getMoneyAmount(int start, int end) {
        if(start == end) {
            return start;
        } else {
            return (start + end) / 2 + getMoneyAmount( end / 2, end );
        }
    }
}
