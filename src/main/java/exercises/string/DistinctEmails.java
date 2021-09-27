package exercises.string;

import java.util.Arrays;

public class DistinctEmails {
  public int numUniqueEmails(final String[] emails) {
    return (int) Arrays.stream(emails)
      .map(this::mapToUnique)
      .distinct()
      .count();
  }

  private String mapToUnique(final String s) {
    final var split = s.split("@");
    final var local = split[0];
    final var emailDomain = "@" + split[1];
    final var resultLocal = new StringBuilder();

    for (final var c : local.toCharArray()) {
      if (c == '+') {
        return resultLocal.append(emailDomain)
          .toString();
      } else if (c != '.') {
        resultLocal.append(c);
      }
    }

    return resultLocal.append(emailDomain)
      .toString();
  }
}
