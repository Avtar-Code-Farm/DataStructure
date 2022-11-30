package Patterns.SlidingWindow.FixedSize;
import java.util.*;

public class PrintFirstNegativeInteger {

    //Given an array and a positive integer k, find the first negative integer for each window(contiguous subarray)
    // of size k. If a window does not contain a negative integer, then print 0 for that window.
    public static void main(String[] args) {
        int arr[] = {12, -1, -7, 8, -15, 30, 16, 28};
        SolutionFirstAttempt(arr, 3);
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
