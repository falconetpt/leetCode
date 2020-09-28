package exercises.string;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class StrongPasswordChecker {
    public int strongPasswordChecker(String s) {
        PriorityQueue<Integer> repeats = new PriorityQueue<>( Comparator.comparingInt( i -> (i % 3) ) );
        int low = 0, up = 0, digit = 0;

        for (int i = 0, j, c, repeat; i < s.length(); i = j) {
            if ((c = s.charAt(i)) >= 'a' && c <= 'z') low = 1;
            else if (c >= 'A' && c <= 'Z') up = 1;
            else if (c >= '0' && c <= '9') digit = 1;
            for (j = i + 1; j < s.length() && c == s.charAt(j); j++);
            if ((repeat = j - i) > 2) repeats.add(repeat);
        }
        int len = s.length(), count = 0, delete = len - 20, insert = 6 - len, type = 3 - low - up - digit, top, change;
        for (; !repeats.isEmpty() && delete-- > 0; count++)//delete operation
            if ((top = repeats.poll()) > 3) repeats.add(--top);
        for (; !repeats.isEmpty() && insert-- > 0; type--, count++)//insert operation
            if ((top = repeats.poll()) > 4) repeats.add(top - 2);
        return (change = repeats.stream().mapToInt(i -> i / 3).sum()) + Math.max(0, delete) + Math.max(0, Math.max(insert, type - change)) + count;
    }



    /**
     * A password is considered strong if below conditions are all met:
     *
     * It has at least 6 characters and at most 20 characters.
     * It must contain at least one lowercase letter, at least one uppercase letter, and at least one digit.
     * It must NOT contain three repeating characters in a row ("...aaa..." is weak, but "...aa...a..." is strong, assuming other conditions are met).
     * Write a function strongPasswordChecker(s), that takes a string s as input, and return the MINIMUM change required to make s a strong password. If s is already strong, return 0.
     *
     * Insertion, deletion or replace of any one character are all considered as one change.
     */
}

