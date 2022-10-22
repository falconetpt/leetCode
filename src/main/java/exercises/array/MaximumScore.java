package exercises.array;

public class MaximumScore {
  public int numDecodings(String s) {
    final var charArr = s.toCharArray();

    var str = 0;
    var cache = new int[charArr.length + 2];
    var result = 0;

    for(int i = charArr.length - 1; i >= 0; i--) {
      if (charArr[i] == '0' && str == 0) {

      } else {
        str += Integer.parseInt(charArr[i] + "");

        if (str <= 26) {
          cache[i] += 1 + cache[i + 2];
        } else if (str < 10) {
          cache[i] += 1 + cache[i + 1];
        }
      }
    }

    return result;
  }
}
