package Patterns.MergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumMeetingRooms {
    public static void main(String[] args) {

        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1,3));
        list.add(new Interval(2,3));
        list.add(new Interval(3, 6));
        list.add(new Interval(5, 8));
        list.add(new Interval(7, 9));

        ///int minRoomCount = findNumberOfRoom(list);

        list = new ArrayList<>();
        list.add(new Interval(4,5));
        list.add(new Interval(2,3));
        list.add(new Interval(2, 4));
        list.add(new Interval(3, 5));

        int minRoomCount2 = findNumberOfRoom(list);

    }

    // idea is to iterate over the list
    // check if there is overlap. if no overlap keep moving
    // if there is overlaop then check if there is any other meeting which started earlier is over. curr_meeting.start > previous_meeting.end
    // If we found one meeting then no need to increment the count other wise simply add the meeting end time to the queue and record the max with queue size
    public static int findNumberOfRoom(List<Interval> list) {
        int max = 1;
        if(list.size() <= 1) return max;

        Collections.sort(list, (a, b) -> Integer.compare(a.start, b.start));

            /// by defualt priority queue is min heap;
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i = 0; i < list.size(); i++) {
            if(!queue.isEmpty() && queue.peek() <= list.get(i).start) queue.poll();
            queue.offer(list.get(i).end);
            max = Math.max(max, queue.size());
        }


        return max;
    }

    public static boolean isOverlap(Interval a, Interval b) {
        int front = Math.max(a.start, b.start);
        int back = Math.min(a.end, b.end);
        return back - front >  0;
    }
}
