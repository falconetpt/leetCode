package exercises.linked.list;

public class Palindrome {
  public boolean isPalindrome(final ListNode head) {
    final var str = isPalindrome(head, new StringBuilder());
    return str.reverse().toString()
      .equals(str.reverse().toString());
  }

  private StringBuilder isPalindrome(final ListNode head, final StringBuilder stringBuilder) {
    if (head == null) {
      return stringBuilder;
    } else {
      stringBuilder.append(head.val);
      return isPalindrome(head.next, stringBuilder);
    }
  }
}
