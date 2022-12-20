package Patterns.MergeIntervals;

import java.util.ArrayList;
import java.util.List;

//Problem Statement #
//Given a list of non-overlapping intervals sorted by their start time, insert a given interval at the correct position
// and merge all necessary intervals to produce a list that has only mutually exclusive intervals.
//
//Example 1:
//
//Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,6]
//Output: [[1,3], [4,7], [8,12]]
//Explanation: After insertion, since [4,6] overlaps with [5,7], we merged them into one [4,7].
//Example 2:
//
//Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,10]
//Output: [[1,3], [4,12]]
//Explanation: After insertion, since [4,10] overlaps with [5,7] & [8,12], we merged them into [4,12].
//Example 3:
//
//Input: Intervals=[[2,3],[5,7]], New Interval=[1,4]
//Output: [[1,4], [5,7]]
//Explanation: After insertion, since [1,4] overlaps with [2,3], we merged them into one [1,4].

public class InsertInterval {
    public static void main(String[] args) {

        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1,3));
        list.add(new Interval(5,7));
        list.add(new Interval(8, 12));
        list.add(new Interval(13, 15));
        Interval temp =  new Interval(4,9);

        List<Interval> resultl = InsertInterval_FUN2(list, temp);

    }

    // solution: Our overall algorithm will look like this:
    //
    //Skip all intervals which end before the start of the new interval,
    // i.e., skip all intervals with the following condition:
    // newInterval.start >= intervals[i].end
    //Let’s call the last interval ‘b’ that does not satisfy the above condition.
    // If ‘b’ overlaps with the new interval (a) (i.e. b.start <= a.end),
    // we need to merge them into a new interval ‘c’:
    //    c.start = min(a.start, b.start)
    //    c.end = max(a.end, b.end)
    //We will repeat the above two steps to merge ‘c’ with the next overlapping interval

    private static List<Interval> InsertInterval_FUN2(List<Interval> list, Interval temp) {

        List<Interval> result = new ArrayList<>();

        // First addd all the interveral to the result until we found an interval whose start > temp.start
        int index = 0;
        while(index < list.size() && !isOverlap(list.get(index), temp)) {
            result.add(list.get(index++));
        }

        while( index < list.size() && isOverlap(list.get(index), temp)) {
            temp.start = Math.min(list.get(index).start, temp.start);
            temp.end = Math.max(list.get(index).end, temp.end);
            index++;
        }

        // now add the new interval after finishing the overalap
        result.add(temp);

        // now add the remaining element to the list
        while(index < list.size()) {
            result.add(list.get(index++));
        }


        return  result;
    }

    private static boolean isOverlap(Interval a, Interval b) {
        int front = Math.max(a.start,b.start);
        int back = Math.min(a.end, b.end);
        return back - front >= 0;
    }


}
