package Patterns.SlidingWindow.VariableSize;

public class MaximumSizeSubarraySumWithPositiveNumber {

    //Largest Subarray of sum K
    // Given an array arr[] of size n containing integers. The problem is to find the length of the longest sub-array having sum equal to the given value k.
    //
    //Examples:
    //
    //Input: arr[] = { 10, 5, 2, 7, 1, 9 }, k = 15
    //Output: 4


    public static void main(String[] args) {
        int target = 5;

        int[] nums = new int[] {4,1,1,1,2,3,5};
        int res = maxSubArrayLen(target, nums);
        System.out.println("max subarray size " + res + " with sum " + target);
    }

    //1. Use two pointers: start and end to represent a window.
    //2. Move end to find a valid window.
    //3. When a valid window is found, move start to find a smaller window.
    public static int maxSubArrayLen(int target, int[] nums ) {
        int max = Integer.MIN_VALUE;

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
                if(sum == target)
                    max = Math.max(max, end - start + 1);
                sum -= nums[start];
                start++;
            }

            // move end to find the sum which is >= target
            end ++;
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }
}
