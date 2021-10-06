package exercises.string;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class LicenseKeyFormatting {
  public String licenseKeyFormatting(final String s, final int k) {
    final var stringArray = Arrays.stream(s.split("[-]"))
      .collect(Collectors.toCollection(LinkedList::new));
    final var result = new StringBuffer(stringArray.pollFirst());

    licenseKeyFormatting(String.join("", stringArray).toUpperCase(), k, 0, result);

    return result.toString();
  }

  private void licenseKeyFormatting(final String stringArray,
                                    final int k,
                                    final int i,
                                    final StringBuffer result) {
    if (i < stringArray.length()) {
      final var character = stringArray.charAt(i);
      if (i % k == 0) result.append("-");
      result.append(character);
      licenseKeyFormatting(stringArray, k, i + 1, result);
    }
  }
}
