package Patterns.SlidingWindow.FixedSize;
import java.util.*;

public class PrintFirstNegativeInteger_2 {

    //Given an array and a positive integer k, find the first negative integer for each window(contiguous subarray)
    // of size k. If a window does not contain a negative integer, then print 0 for that window.
    public static void main(String[] args) {
        int arr[] = {12, -1, -7, 8, -15, 30, 16, 28};

        SimpliefiedSingleLoop(arr, 3);

        SolutionFirstAttempt(arr, 3);


    }

    private static void SimpliefiedSingleLoop(int[] nums, int k) {

        int start = 0;
        Deque<Integer> deq = new ArrayDeque<>();

        for(int end = 0; end < nums.length; end++) {
            if(nums[end] < 0) deq.addLast(nums[end]);

            // once the window exists, start printing top and increment start
            if(end - start + 1 == k) {
                int top = deq.size() == 0 ? 0 : deq.getFirst();
                System.out.print(" " + top + " ");

                // now check if we need to pop top element from the dequeue
                if(deq.size() > 0 && nums[start] == deq.getFirst()) {
                    deq.pop();
                }

                start++;
            }
        }
    }

    public static void SolutionFirstAttempt(int[] nums, int k) {
        if( k > nums.length) return;
        if(nums.length == 0) return;

        // initialize list
        // Initializing a deque
        Deque<Integer> dq = new ArrayDeque<Integer>();

        // perform first iteration for k element and load the deque with negatives if exists.
        for(int i = 0; i < k; i++) {
            if(nums[i] < 0) dq.add(nums[i]);
        }

        int start = 0;
        int end = k-1;
        while(end < nums.length ) {
            int print_val = dq.size() > 0 ? dq.getFirst() : 0 ;
            System.out.print(" " + print_val);

            // Remove an element form the queue if it matches with value at start index
            if(print_val == nums[start]) {

                dq.pop();
            }
            // move the window
            start++;
            end++;

            // we found another negative number, add it to the list.
            if(end < nums.length && nums[end] < 0) {
                dq.addLast(nums[end]);
            }

        }

    }
}
