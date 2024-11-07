package u.exercises;

public class MakeFancyString {
  public String makeFancyString(String s) {
    final var stringBuilder = new StringBuilder();
    stringBuilder.append(s.charAt(0));
    var count = 1;
    final var newStr = s + " "; // Add a new empty string at the end for simplicity of code


    for (int i = 1; i < newStr.length(); i++) {
      final var currentElement = newStr.charAt(i);
      if (newStr.charAt(i-1) != currentElement) {
        count = 1;
        if (currentElement != ' ') stringBuilder.append(currentElement);
      } else {
        count++;
        if (count < 3) {
          stringBuilder.append(currentElement);
        }
      }

    }

    return stringBuilder.toString();
  }
}
