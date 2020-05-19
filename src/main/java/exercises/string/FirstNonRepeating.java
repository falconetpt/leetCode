package exercises.string;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FirstNonRepeating {
    public int firstUniqChar(String s) {
        PriorityQueue<Integer> indexes = new PriorityQueue<>(  );
        Map<Character, Integer> map = new HashMap<>(  );
        return firstUniqChar(s.toCharArray(), indexes, map, 0);
    }

    private int firstUniqChar(char[] a,
                              PriorityQueue<Integer> indexes,
                              Map<Character, Integer> seen,
                              int i) {
        if(i >= a.length) {
            return indexes.isEmpty() ? -1 : indexes.poll();
        } else {
            char key = a[i];
            if (seen.containsKey( key ))  {
                indexes.remove( seen.get(key) );
            } else {
                indexes.add(i);
            }
            seen.put( key, i );

            return firstUniqChar( a, indexes, seen, i + 1 );
        }
    }
}
