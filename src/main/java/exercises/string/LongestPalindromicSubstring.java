package exercises.string;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindromicSubstring {
    public String longestPalindrome(final String s) {
        return longestPalindrome(s, new HashMap<>());
    }

    private String longestPalindrome(final String s, final Map<String, String> cache) {
        String result = "";
        for (int i = 0; i < s.length() -1; i++) {
            for (int j = s.length(); j >= i; j --) {
                String value = s.substring(i, j);
                if (isPalindrome(value)) {
                    result = value.length() > result.length() ? value : result;
                }
            }
        }

        return result;
    }

    private boolean isPalindrome(final String s) {
        if (s.length() <= 1) {
            return true;
        } else {
            return new StringBuilder(s).reverse().toString().equals(s);
        }
    }

    /**
     * https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/780/
     *
     * Given a string s, find the longest palindromic substring in s.
     * You may assume that the maximum length of s is 1000.
     *
     * Example 1:
     *
     * Input: "babad"
     * Output: "bab"
     * Note: "aba" is also a valid answer.
     * Example 2:
     *
     * Input: "cbbd"
     * Output: "bb"
     */
}
