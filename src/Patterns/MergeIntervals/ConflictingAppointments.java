package Patterns.MergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConflictingAppointments {
    public static void main(String[] args) {

        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1,3));
        list.add(new Interval(5,7));
        list.add(new Interval(6, 12));
        list.add(new Interval(13, 15));


        boolean result = canAttendAllAppointments(list);


    }

    public static boolean canAttendAllAppointments(List<Interval> list) {
        if(list.size() == 0) return false;
        else if(list.size() == 1) return true;

        Collections.sort(list, (a, b) -> Integer.compare(a.start, b.start));

        Interval current =list.get(0);

        for(int i = 1; i < list.size(); i++) {
            if(isOverlap(current, list.get(i))) {
                return false;
            }
            current = list.get(i);
        }
        return true;
    }

    public static boolean isOverlap(Interval a, Interval b) {
        int front = Math.max(a.start, b.start);
        int back = Math.min(a.end, b.end);
        return back - front > 0;
    }
}
