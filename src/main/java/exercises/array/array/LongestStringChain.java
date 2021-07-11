package exercises.array.array;

import java.util.Arrays;

public class LongestStringChain {
    public int longestStrChain(String[] words) {
        StringTree st = new StringTree();
        Arrays.stream(words).forEach( st::addWord );

        return st.getMaxLength();
    }

    public class StringTree {
        private StringTree[] letters;
        private int maxLength;

        public StringTree() {
            letters = new StringTree[26];
            maxLength = 0;
        }

        public int getMaxLength() {
            return maxLength;
        }

        public void addWord(String word) {
            addWord( word, 0 );
        }

        private void addWord(String word, int i) {
            if (i < word.length()) {
                int index = word.charAt( i ) - 'a';
                if (letters[index] == null) letters[index] = new StringTree();
                letters[index].addWord( word, i + 1 );
            }
        }
    }
}
