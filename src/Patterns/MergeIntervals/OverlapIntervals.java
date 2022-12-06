package Patterns.MergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OverlapIntervals {
    public static void main(String[] args) {

        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1,3));
        list.add(new Interval(5,6));
        list.add(new Interval(7, 9));

        List<Interval> list_2 = new ArrayList<>();
        list_2.add(new Interval(2,3));
        list_2.add(new Interval(5,7));


        List<Interval> resultl = FindOverlapBetweenTwoInterval(list, list_2);

    }

    public static List<Interval> FindOverlapBetweenTwoInterval(List<Interval> first, List<Interval> second) {
        List<Interval> output = new ArrayList<>();


        Collections.sort(first, (a, b) -> Integer.compare(a.start, b.start));
        Collections.sort(second, (a, b) -> Integer.compare(a.start, b.start));

        int i = 0;
        int j = 0;

        while( i < first.size() && j < second.size()) {
            Interval a = first.get(i);
            Interval b = second.get(j);

            if(isOverlap(a,b)) {
                int start = Math.max(a.start, b.start);
                int end = Math.min(a.end, b.end);
                output.add(new Interval(start,end));
            }

            // move next from the interval which is finishing first
            if(a.end < b.end)
                i++;
            else
                j++;
        }
        return output;
    }


    private static boolean isOverlap(Interval a, Interval b) {
        int front = Math.max(a.start,b.start);
        int back = Math.min(a.end, b.end);
        return back - front >= 0;
    }
}
