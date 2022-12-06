package Patterns.MergeIntervals;

//Problem Statement #
//Given a list of intervals, merge all the overlapping intervals to produce a list that has only mutually exclusive intervals.
//
//Example 1:
//
//Intervals: [[1,4], [2,5], [7,9]]
//Output: [[1,5], [7,9]]
//Explanation: Since the first two intervals [1,4] and [2,5] overlap, we merged them into
//one [1,5].

// Solution -> https://www.youtube.com/watch?v=qKczfGUrFY4

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class Interval {
      int start;
      int end;
        public Interval(int a, int b) {
            start = a;
            end = b;
        }
}

// understand how to find overalap interval: https://medium.com/@timpark0807/leetcode-is-easy-the-interval-pattern-d68a7c1c841


public class MergeIntervals {
    public static void main(String[] args) {

        List<Interval> list = new ArrayList<>();
//  intervals = [[1,3],[5,10],[7,15],[18,30],[22,25]]
//Partial Overlap
// [5     10]
//     [7       15]
//becomes...
//[5            15]
//Complete Overlap
//[18                30]
//      [22   25]
//becomes...
//[18                30]
        list.add(new Interval(1,3));
        list.add(new Interval(5,10));
        list.add(new Interval(7,15));
        list.add(new Interval(18,30));
        list.add(new Interval(22,25));


        List<Interval> resultl = MergeOverlapInterval(list);

    }

    public static List<Interval> MergeOverlapInterval(List<Interval> input) {
        List<Interval> output = new ArrayList<>();
        if(input.size() <= 1) return input;

        Collections.sort(input, (a, b) -> Integer.compare(a.start, b.start));

        Interval current  = input.get(0);

        for(int i = 0; i < input.size(); i++) {
            Interval next = input.get(i);

            if(isOverlap(current, next)){
                // merge it but don't add it to result because we have to check it with the next interval before adding it to the result
                current.end = Math.max(current.end, next.end);
            } else {
                output.add(current);
                current = next;
            }
        }
        output.add(current);
        return output;
    }

    public static List<Interval> FindOverlapBetweenTwoInterval(List<Interval> first, List<Interval> second) {
        List<Interval> output = new ArrayList<>();


        Collections.sort(first, (a, b) -> Integer.compare(a.start, b.start));
        Collections.sort(second, (a, b) -> Integer.compare(a.start, b.start));

        int i = 0;
        int j = 0;

        while( i < first.size() && j < second.size()) {
            Interval a = first.get(i);
            Interval b = second.get(i);

            if(isOverlap(a,b)) {
                int start = Math.max(a.start, b.start);
                int end = Math.min(a.end, b.end);
                i++;
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


    //intervals = [[1,3],[5,10],[7,15],[18,30],[22,25]]
    //               0      1      2      3        4
    //# CASE 1
    //interval[0] = [1, 3]
    //interval[1] = [5, 10]
    //front = max(1, 5) = 5
    //back = min(3, 10) = 3
    //back - front = 3 - 5 = -2
    //Explanation: The intervals 'overlap' by -2, aka they don't overlap
    //# CASE 2
    //interval[1] = [5, 10]
    //interval[2] = [7, 15]
    //front = max(5, 7) = 7
    //back = min(10, 15) = 10
    //back - front = 10 - 7 = 3
    //Explanation: The intervals overlap by 3
    //# CASE 3
    //interval[3] = [18, 30]
    //interval[4] = [22, 25]
    //
    //front = max(18, 22) = 22
    //back = min(30, 25) = 25
    //back - front = 25 - 22 = 3
    //Explanation: The intervals overlap by 3
    private static boolean isOverlap(Interval a, Interval b) {
        int front = Math.max(a.start,b.start);
        int back = Math.min(a.end, b.end);
        return back - front >= 0;
    }
}
