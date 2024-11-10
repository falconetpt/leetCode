package questions75;

import java.util.LinkedList;

public class GcdOfStrings {
  public String gcdOfStrings(String str1, String str2) {
    if (str2.length() > str1.length()) return gcdOfStrings(str2, str1);
    final var sb = new StringBuilder();
    final var linkedList = new LinkedList<String>();

    for (int i = 0; i < str2.length(); i++) {
      sb.append(str2.charAt(i));
      final var str1Times =   str1.length() / sb.length();
      final var str2Times =  str2.length() / sb.length();

      final var equalsStr1Expanded = sb.toString().repeat(str1Times).equals(str1);
      final var equalsStr2Expanded = sb.toString().repeat(str2Times).equals(str2);

      if (equalsStr1Expanded && equalsStr2Expanded) linkedList.add(sb.toString());
    }

    return linkedList.isEmpty()
        ? ""
        : linkedList.pollLast();
  }
}
