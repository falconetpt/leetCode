package meetingRoom;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MeetingRoom2Test {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void minNumOfMeetingRooms() {
    final var output = new MeetingRoom2().minNumOfMeetingRooms(new int[][]{
        {0, 30},
        {5, 10},
        {15, 20}
    });

    final var output2 = new MeetingRoom2().minNumOfMeetingRooms(new int[][]{
        {7, 10}, {2, 4}
    });
    final var output3 = new MeetingRoom2().minNumOfMeetingRooms(new int[][]{
        {0, 30}, {5, 10}, {15, 20}, {25, 35}
    });
    final var output4 = new MeetingRoom2().minNumOfMeetingRooms(new int[][]{
        {0, 30}, {5, 10}, {15, 25}, {20, 30}
    });


    System.out.println("output = " + output);
    System.out.println("output = " + output2);
    System.out.println("output = " + output3);
    System.out.println("output = " + output4);
  }
}