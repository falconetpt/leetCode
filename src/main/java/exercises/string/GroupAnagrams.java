package exercises.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        Consumer<String> processString = str -> {
            String key = Arrays.stream(str.split("")).sorted().reduce("", String::concat);
            result.putIfAbsent(key, new ArrayList<>());
            result.get(key).add(str);
        };

        Arrays.stream(strs).forEach(processString);

        return new ArrayList<>(result.values());
    }



    /**
     * https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/778/
     *
     * Given an array of strings, group anagrams together.
     *
     * Example:
     *
     * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
     * Output:
     * [
     *   ["ate","eat","tea"],
     *   ["nat","tan"],
     *   ["bat"]
     * ]
     * Note:
     *
     * All inputs will be in lowercase.
     * The order of your output does not matter.
     */
}
