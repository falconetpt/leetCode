package exercises.array.array;

public class BulbSwitcher {
    public int numTimesAllBlue(int[] light) {
        return numTimesAllBlue( light, Integer.MIN_VALUE, 0 );
    }

    private int numTimesAllBlue(int[] light, int maxValue, int i) {
        if (i > light.length) {
            return 0;
        } else {
            int newIndex = light[i];
            int newMaxValue = Math.max( newIndex, maxValue );

            return (newMaxValue == i + 1 ? 1 : 0) + numTimesAllBlue( light, newMaxValue, i + 1 );
        }
    }
}
