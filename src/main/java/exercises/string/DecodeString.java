package exercises.string;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DecodeString {
    public String decodeAtIndex(final String S, final int K) {
        if (S == null) {
            return "";
        } else {
            return decodeAtIndex(S, K, 0, "" , new StringBuilder());
        }
    }

    private String decodeAtIndex(String s, int k, int i, String currentString, StringBuilder stringBuilder) {
        if (i >= s.length()) stringBuilder.append(currentString);

        if (stringBuilder.length() >= k) {
            return String.valueOf(stringBuilder.toString().charAt(k - 1));
        } else {
            int index = i;
            int repeat = 0;


            while (index < s.length() && String.valueOf(s.charAt(index)).matches("[0-9]")
                    && repeat < k) {
                repeat *=10;
                repeat += Integer.parseInt(String.valueOf(s.charAt(index)));
                index++;
            }

            if (repeat > 0) {
                IntStream.range(0, repeat - 1).forEach(x -> stringBuilder.append(currentString));
                return decodeAtIndex(s, k, index, stringBuilder.toString(), stringBuilder);
            } else {
                stringBuilder.append(s.charAt(i));
                return decodeAtIndex(s, k, i + 1, stringBuilder.toString(), stringBuilder);
            }
        }
    }
}
