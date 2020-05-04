package exercises.array;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindItenerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, String> route = new HashMap<>(  );

        tickets.forEach( it -> {
            if (route.containsKey( it.get( 0 ) )) {
                route.put(
                        it.get( 0 ), Stream.of(it.get( 1 ),
                        route.get( it.get( 0 ) )).sorted().findFirst().orElse( "" )
                );
            } else {
                route.put( it.get( 0 ), it.get( 1 ) );
            }
        } );

        return createItenerary(route, "JFK", Stream.of( "JFK" ).collect( Collectors.toList()));
    }

    private List<String> createItenerary(Map<String, String> route, String base, List<String> result) {
        if (route.containsKey( base )) {
            String next = route.get( base );
            result.add( next );
            return createItenerary( route, next, result );
        } else {
            return result;
        }
    }


    /**
     *
     * Given a list of airline tickets represented by pairs of departure and arrival airports
     * [from, to], reconstruct the itinerary in order.
     * All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
     *
     * Note:
     *
     * If there are multiple valid itineraries, you should return the itinerary that has
     * the smallest lexical order when read as a single string.
     * For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
     * All airports are represented by three capital letters (IATA code).
     * You may assume all tickets form at least one valid itinerary.
     * Example 1:
     *
     * Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
     * Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
     * Example 2:
     *
     * Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
     * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
     * Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
     *              But it is larger in lexical order.
     *
     */
}
