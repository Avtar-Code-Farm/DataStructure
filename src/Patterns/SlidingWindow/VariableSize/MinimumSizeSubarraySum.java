package Patterns.SlidingWindow.VariableSize;

public class MinimumSizeSubarraySum {

    //Given an array of positive integers nums and a positive integer target,
    // return the minimal length of a subarray whose sum is greater than or equal to target.
    // If there is no such subarray, return 0 instead.

    // https://leetcode.com/problems/minimum-size-subarray-sum/


    public static void main(String[] args) {
        int target = 5;

        int[] nums = new int[] {2,4,5,1,1,1,1,1,5};
        int res = minSubArrayLen(target, nums);
        System.out.println("Min subarray size " + res + " with sum " + target);
    }

    //1. Use two pointers: start and end to represent a window.
    //2. Move end to find a valid window.
    //3. When a valid window is found, move start to find a smaller window.
    public static int minSubArrayLen(int target, int[] nums ) {
        int min = Integer.MAX_VALUE;

        int start = 0;
        int end = 0;
        int sum = nums[0];

        if(sum > target) return 1;
        sum  = 0;

        while(end < nums.length) {
            sum += nums[end];

            // reduce the window size once the sum found
            // or basically Move start to find a smaller window.
            while(sum >= target && start <= end) {
                min = Math.min(min, end - start + 1);
                sum -= nums[start];
                start++;
            }

            // move end to find the sum which is >= target
            end ++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
