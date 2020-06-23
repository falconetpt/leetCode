package exercises.array;

import java.util.Arrays;
import java.util.Comparator;

public class TwoCityScheduleCost {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, Comparator.comparingInt( a -> (a[0] - a[1]) ) );
        return twoCitySchedCost( costs, 0, costs.length / 2 );
    }

    private int twoCitySchedCost(int[][] costs, int index, int midPoint) {
        if (index >= costs.length) {
            return 0;
        } else {
            int city = index >= midPoint ? 1 : 0;
            return costs[index][city] + twoCitySchedCost( costs, index + 1, midPoint );
        }
    }
}
