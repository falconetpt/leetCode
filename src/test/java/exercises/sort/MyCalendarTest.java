package exercises.sort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyCalendarTest {
  private MyCalendar myCalendar;

  @BeforeEach
  private void setup() {
    myCalendar = new MyCalendar();
  }

  @Test
  void test1() {
    assertTrue( myCalendar.book( 47,50) );
    assertTrue(myCalendar.book(33,41));
    assertFalse(  myCalendar.book(39,45) );
    assertFalse(  myCalendar.book(33,42) );
    assertTrue( myCalendar.book(25,32) );
    assertFalse(   myCalendar.book(26,35) );
    assertTrue( myCalendar.book(19,25));
    assertTrue( myCalendar.book(3,8) );
    assertTrue( myCalendar.book(8,13) );
    assertFalse( myCalendar.book(18,27) );
  }

}