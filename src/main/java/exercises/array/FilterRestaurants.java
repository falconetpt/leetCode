package exercises.array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterRestaurants {
    public List<Integer> filterRestaurants(
            int[][] restaurants,
            int veganFriendly,
            int maxPrice,
            int maxDistance) {


        return Arrays.stream(restaurants)
                .filter( i -> veganFriendly != 1 || i[2] == veganFriendly )
                .filter( i -> i[3] <= maxPrice )
                .filter( i -> i[4] <= maxDistance )
                .sorted( (a, b) -> - (a[0] - b[0]) )
                .sorted( (a, b) -> - (a[1] - b[1]) )
                .map( i -> i[1] )
                .collect( Collectors.toList() );

    }
}
