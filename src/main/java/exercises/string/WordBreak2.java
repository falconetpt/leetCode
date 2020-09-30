package exercises.string;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WordBreak2 {
    public boolean wordBreak(String s, List<String> wordDict) {
        String wordDictSet = wordDict.stream().reduce( "", String::concat );


        if (s.isEmpty()) {
            return false;
        } else {
            return wordBreak( s, wordDict.stream().sorted( (a, b) -> - (a.length() - b.length()) )
                    .collect( Collectors.toList()), 0 );
        }
    }

    public boolean wordBreak(String s, List<String> wordDict, int offset) {
        if (offset >= s.length()) {
            return true;
        } else {
            return wordDict.stream()
                    .filter( w -> s.startsWith( w, offset ) )
                    .anyMatch( w -> wordBreak( s, wordDict, offset + w.length() ) );
        }
    }
}
