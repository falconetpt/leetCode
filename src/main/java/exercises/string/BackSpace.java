package exercises.string;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BackSpace {
    public boolean backspaceCompare(String S, String T) {
        String sTrim = trimStrim(S, 0, new Stack<>() );
        String tTrim = trimStrim(T, 0, new Stack<>() );
        System.out.println(sTrim + ":" + tTrim);

        return sTrim.equals( tTrim );
    }

    private String trimStrim(String s, int index, Stack<Character> characters) {
        if (index >= s.length()) {
            return characters.stream()
                    .map( String::valueOf )
                    .reduce( "", String::concat );
        } else {
            char element = s.charAt( index );

            if (element == '#') {
                if(!characters.isEmpty()) characters.pop();
            } else {
                characters.add( element );
            }

            return trimStrim( s, index + 1, characters );
        }
    }
}
