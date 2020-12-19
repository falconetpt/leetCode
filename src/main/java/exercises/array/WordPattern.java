package exercises.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] wordArray = str.split( " " );
        HashMap<Character, List<Integer>> patternMap = new HashMap<>(  );

        IntStream.range( 0, pattern.length() )
                .forEach( i -> {
                    char c = pattern.charAt( i );
                    patternMap.putIfAbsent( c, new ArrayList<>(  ) );
                    patternMap.get( c ).add( i );
                } );



        if (wordArray.length == pattern.length()) {
            for (int i = 0; i< pattern.length(); i++) {
                char c = pattern.charAt( i );
                String value = wordArray[i];

                if (!patternMap.get( c ).stream().allMatch( e ->  wordArray[e].equals( value ) )) {
                    return false;
                }
            }

            return Stream.of(wordArray).distinct().count() == patternMap.keySet().size() && wordArray.length == pattern.length();
        } else {
            return false;
        }

    }
}
