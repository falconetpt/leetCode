package exercises.array.array;

import java.util.Arrays;

public class CherryPick {
    public int cherryPickup(final int[][] grid) {
        //11401
        return Arrays.stream(grid)
                .map(i -> Arrays.stream(i).sum())
                .reduce(0, Integer::sum);
    }
}
