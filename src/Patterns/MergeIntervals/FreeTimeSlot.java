package Patterns.MergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static Patterns.MergeIntervals.ConflictingAppointments.isOverlap;

public class FreeTimeSlot {
    public static void main(String[] args) {

        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1,3));
        list.add(new Interval(5,6));

        List<List<Interval>> time_list = new ArrayList<List<Interval>>();
        time_list.add(list);

        list = new ArrayList<>();
        list.add(new Interval(2,3));
        list.add(new Interval(6,8));
        time_list.add(list);

        List<Interval> result = FineFreeTimeSlots(time_list);

    }

    private static List<Interval> FineFreeTimeSlots(List<List<Interval>> time_list) {
        List<Interval> intervals = MergeTimeIntervals(time_list);
        List<Interval> result = new ArrayList<>();

        Collections.sort(intervals, (a,b) -> Integer.compare(a.start, b.start));

        Interval current = intervals.get(0);

        for(int i = 1; i < intervals.size(); i++) {
            Interval next = intervals.get(i);

            if(!isOverlap(current,next)) {
                int start = current.end;
                int end = next.start;
                Interval temp = new Interval(start, end);
                result.add(temp);
            }
            current = next;
        }

        return result;
    }

    private static List<Interval> MergeTimeIntervals(List<List<Interval>> time_list) {
        List<Interval> result = new ArrayList<>();

        for(int i = 0; i < time_list.size(); i++)
        {
            List<Interval> temp = time_list.get(i);
            result.addAll(temp);
        }
        return result;
    }

    public static boolean isOverlap(Interval a, Interval b) {
        int front = Math.max(a.start, b.start);
        int back = Math.min(a.end, b.end);
        return back - front >= 0;
    }
}
