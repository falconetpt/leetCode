package exercises.objects;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MyCalendar {
    List<Point> list;

    public MyCalendar() {
        list = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        if(list.stream().allMatch( p -> (start < p.x && end <= p.x) || (end >= p.y && start >= p.y) )) {
            return list.add( new Point( start, end ) );
        } else {
            return false;
        }
    }
}
