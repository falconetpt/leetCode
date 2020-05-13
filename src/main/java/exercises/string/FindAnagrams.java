package exercises.string;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) {
            return new ArrayList<>(  );
        } else {
            int[] result = new int[26];

            for (char c: p.toCharArray()) {
                result[c - 'a']++;
            }

            return findAnagrams( s, 0, p.length(), new ArrayList<>(  ), result );
        }
    }

    private List<Integer> findAnagrams(String s, int i, int length,
                                       List<Integer> result, int[] frequency) {
        if (i + length >= s.length()) {
            return result;
        } else {
            int[] local = new int[26];
            IntStream.rangeClosed( i, i + length - 1).forEach( index -> local[s.charAt( index )-'a']++ );
            boolean valid = IntStream.range( 0, 26 ).allMatch( index -> frequency[index] == local[index] );

            if (valid) result.add( i );

            return findAnagrams( s, i + 1, length, result, frequency );
        }
    }

}
