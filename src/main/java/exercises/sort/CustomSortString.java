package exercises.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomSortString {
    public String customSortString(String S, String T) {
        Map<String, Long> charCount = Arrays.stream(T.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return customSortString(S, charCount, new HashSet<>(), 0);
    }

    private String customSortString(String order, Map<String, Long> charCount, HashSet<String> seen, int index) {
        if (index >= order.length()) {
            charCount.keySet().removeAll(seen);
            return charCount.keySet().stream()
                    .map(k -> String.join("", Collections.nCopies(charCount.get(k).intValue(), k)) )
                    .reduce("", String::concat);
        } else {
            String key = String.valueOf(order.charAt(index));
            String result = charCount.containsKey(key) ?
                    String.join("", Collections.nCopies(charCount.get(key).intValue(), key)) : "";
            seen.add(key);

            return result + customSortString(order, charCount, seen, index + 1);
        }
    }


    /**
     * https://leetcode.com/problems/custom-sort-string/
     *
     * S and T are strings composed of lowercase letters. In S, no letter occurs more than once.
     *
     * S was sorted in some custom order previously. We want to permute the characters of T so that they match the order that S was sorted. More specifically, if x occurs before y in S, then x should occur before y in the returned string.
     *
     * Return any permutation of T (as a string) that satisfies this property.
     *
     * Example :
     * Input:
     * S = "cba"
     * T = "abcd"
     * Output: "cbad"
     * Explanation:
     * "a", "b", "c" appear in S, so the order of "a", "b", "c" should be "c", "b", and "a".
     * Since "d" does not appear in S, it can be at any position in T. "dcba", "cdba", "cbda" are also valid outputs.
     *
     *
     * Note:
     *
     * S has length at most 26, and no character is repeated in S.
     * T has length at most 200.
     * S and T consist of lowercase letters only.
     */
}
