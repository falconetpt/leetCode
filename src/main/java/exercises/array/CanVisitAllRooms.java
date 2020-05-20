package exercises.array;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CanVisitAllRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms.isEmpty()) {
            return true;
        } else {
            LinkedList<Integer> keys = rooms.stream()
                    .limit( 1 )
                    .flatMap( Collection::stream )
                    .collect( Collectors.toCollection( LinkedList::new) );

            return canVisitAllRooms( rooms, rooms.size(), keys, Stream.of(0).collect( Collectors.toSet()) );
        }
    }

    private boolean canVisitAllRooms(List<List<Integer>> rooms,
                                     int roomsTovisit,
                                     LinkedList<Integer> keys,
                                     Set<Integer> seen) {
        if(roomsTovisit == 0) {
            return true;
        } else if (keys.isEmpty()) {
            return false;
        } else {
            int room = keys.pollFirst();
            seen.add( room );
            rooms.get( room ).stream()
                    .filter( i -> !seen.contains( room ) )
                    .forEach( keys::add );
            return canVisitAllRooms( rooms, roomsTovisit - 1, keys, seen );
        }
    }
}
