package exercises.string;

import java.util.*;

public class WordBreak {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictionary = new HashSet<>( wordDict );
        int max = wordDict.stream().map( String::length ).max( Integer::compareTo ).orElse( 0 );
        return wordBreak( s, "", "", max, 0, wordDictionary, new ArrayList<>() );
    }

    private List<String> wordBreak(String s,
                                   String value,
                                   String acc,
                                   int max,
                                   int i,
                                   Set<String> wordDict,
                                   List<String> result) {
        if (i >= s.length()) {
            if (wordDict.contains( value )) result.add( acc.trim() + " " + value );
            return result;
        } else if (value.length() > max) {
            return result;
        } else {
            if (wordDict.contains( value )) {
                wordBreak( s, String.valueOf(s.charAt(i)), acc + " " + value, max, i + 1, wordDict, result );
            }

            return wordBreak( s, value + s.charAt( i ), acc, max, i + 1, wordDict, result );
        }
    }
}
