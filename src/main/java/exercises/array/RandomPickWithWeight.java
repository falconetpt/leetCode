package exercises.array;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class RandomPickWithWeight {
    class Solution {
        TreeMap<Integer, Integer> map;
        int max;

        public Solution(int[] w) {
            map = generateMap(w, 0, 0, new TreeMap<>() );
            max = Arrays.stream(w).sum();
        }

        public int pickIndex() {
            Random ran = new Random();
            int x = ran.nextInt(max + 1);
            Integer value = map.floorKey( x );
            return map.getOrDefault( value, 0 );
        }

        private TreeMap<Integer, Integer> generateMap(int[] w, int i,
                                                  int number, TreeMap<Integer, Integer> map) {
            if (i >= w.length) {
                return map;
            } else {
                map.put( number, i );
                return generateMap( w, i + 1, number + w[i], map );
            }
        }
    }

}
