package questions75;

public class ReverseString {
  public String reverseWords(String s) {
    final var arrays = s.trim().split("\s+");
    final var result = new StringBuilder();

    for (int i = arrays.length - 1; i >= 0 ; i--) {
      result.append(arrays[i] + " ");
    }


    return result.toString().trim();
  }
}
