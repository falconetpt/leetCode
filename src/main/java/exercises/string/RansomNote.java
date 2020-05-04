package exercises.string;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || ransomNote.isEmpty()) {
            return true;
        } else {
            Map<String, Long> ransonNoteFrequency = Arrays.stream(ransomNote.split( "" ))
                    .collect( Collectors.groupingBy( Function.identity(), Collectors.counting()) );
            Map<String, Long> magazineFrequency = Arrays.stream(magazine.split( "" ))
                    .collect( Collectors.groupingBy( Function.identity(), Collectors.counting()) );

            return ransonNoteFrequency.keySet().stream()
                    .allMatch( k -> ransonNoteFrequency.get( k ) <= magazineFrequency.getOrDefault( k, 0L ) );
        }
    }

    /**
     * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3318/
     *
     * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
     *
     * Each letter in the magazine string can only be used once in your ransom note.
     *
     * Note:
     * You may assume that both strings contain only lowercase letters.
     *
     * canConstruct("a", "b") -> false
     * canConstruct("aa", "ab") -> false
     * canConstruct("aa", "aab") -> true
     */
}
