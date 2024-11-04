package exercises.u.exercises;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MinNumberOfCoursesTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void minNumberSemesters() {
    final var x  = new MinNumberOfCourses();
    final var y1 = x.minNumberSemesters(3, new int[][] {{1,3},{2,3}});
    final var y2 = x.minNumberSemesters(3, new int[][] {{1,2},{2,3},{3,1}});
    final var y3 = x.minNumberSemesters(4, new int[][] {{1,2},{2,3},{3,4},{4,2}});
    final var y4 = x.minNumberSemesters(4, new int[][] {{1,2},{2,3},{3,4},{2,4}});

    System.out.println("y = " + y1);
    System.out.println("y = " + y2);
    System.out.println("y = " + y3);
    System.out.println("y = " + y4);
  }
}