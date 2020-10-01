package exercises.objects;

import java.util.TreeSet;

public class RecentCounter {
    private TreeSet<Integer> pings;

    public RecentCounter() {
        pings = new TreeSet<>(  );
    }

    public int ping(int t) {
        pings.add( t );
        return pings.subSet( t - 3000, t ).size();
    }
}
