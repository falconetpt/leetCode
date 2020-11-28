package exercises.string;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BackSpace {
    public boolean backspaceCompare(String S, String T) {
        return trimStrim(S, 0, new Stack<>() )
                .equals( trimStrim(T, 0, new Stack<>() ) );
    }

    private Stack<Character> trimStrim(String s, int index, Stack<Character> characters) {
        if (index >= s.length()) {
            return characters;
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
