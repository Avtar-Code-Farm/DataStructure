package Patterns.SlidingWindow.VariableSize;

public class MinimumSizeSubarraySum {

    //Given an array of positive integers nums and a positive integer target,
    // return the minimal length of a subarray whose sum is greater than or equal to target.
    // If there is no such subarray, return 0 instead.

    // https://leetcode.com/problems/minimum-size-subarray-sum/


    public static void main(String[] args) {
        int target = 5;

        int[] nums = new int[] {2,4,5,1,1,1,1,1,5};
        int res = minSubArrayLen(5, nums);
        System.out.println("Max subarray size " + res + " with sum " + target);
    }

    //1. Use two pointers: start and end to represent a window.
    //2. Move end to find a valid window.
    //3. When a valid window is found, move start to find a smaller window.
    public static int minSubArrayLen(int target, int[] nums ) {
        int sum =0, max =0;

        int start = 0;
        for(int end = 0; end < nums.length; end++) {
            // keep adding sum
            sum += nums[end];

            // once the sum target found then remove the start sum and increment sum
            if(sum >= target) {
                max = Math.max(max, end - start + 1);
                sum -= nums[start];
                start++;
            }
        }
        return max;
    }
}
