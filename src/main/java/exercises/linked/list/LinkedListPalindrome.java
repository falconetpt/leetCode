package exercises.linked.list;

public class LinkedListPalindrome {
  public boolean isPalindrome(final ListNode head) {
    final var buffer = isPalindrome( head, new StringBuffer(  ));

    return buffer.toString()
      .equals( buffer.reverse().toString() );
  }

  private StringBuffer isPalindrome(final ListNode head, final StringBuffer stringBuffer) {
    if (head == null) {
      return stringBuffer;
    } else {
      stringBuffer.append( head.val );
      return isPalindrome( head.next, stringBuffer );
    }
  }
}
