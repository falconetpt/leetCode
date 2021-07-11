package exercises.array.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FriendRequest {
    public int numFriendRequests(int[] ages) {
        Map<Integer, Long> count = Arrays.stream(ages).boxed()
                .collect( Collectors.groupingBy( Function.identity(), Collectors.counting() ));

        List<Integer> keys = new ArrayList<>( count.keySet() );
        int friendRequests = 0;

        for (int i = 0; i < keys.size(); i++) {
            for (int j = i + 1; j < keys.size(); j++) {
                int ageA = keys.get( i );
                int ageB = keys.get( j );

                if (!(ageB <= 0.5 * ageA + 7 || ageB > ageA || ageB > 100 && ageA < 100)) {
                    friendRequests+=count.getOrDefault( ageB, 0L );
                }
            }
        }

        return friendRequests;
    }
}
