package exercises.string;

import java.util.Arrays;
import java.util.Objects;

public class StreamChecker {
    private StreamCheckerTrie streamCheckerTrie;

    public StreamChecker(String[] words) {
        streamCheckerTrie = new StreamCheckerTrie();
        Arrays.stream(words).forEach( streamCheckerTrie::addWord );
    }

    public boolean query(char letter) {
        return streamCheckerTrie.search( letter );
    }

    private class StreamCheckerTrie {
        private StreamCheckerTrie[] streamCheckerTries;

        public StreamCheckerTrie() {
            streamCheckerTries = new StreamCheckerTrie[26];
        }

        public void addWord(final String word) {
            int index = word.charAt( word.length() - 1 ) - 'a';
            if (streamCheckerTries[index] == null) streamCheckerTries[index] = new StreamCheckerTrie();
        }

        public boolean search(final char word) {
            int index = word - 'a';
            return Objects.nonNull(streamCheckerTries[index]);
        }
    }
}
