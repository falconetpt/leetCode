package exercises.number;

public class PowerOfFour {
    public boolean isPowerOfFour(int num) {
        if (num == 0) return false;
        double rootOffour = Math.round(Math.pow( num, 1/4.0 ));
        return Double.compare( Math.pow(  rootOffour, 4), num) == 0;
    }
}
