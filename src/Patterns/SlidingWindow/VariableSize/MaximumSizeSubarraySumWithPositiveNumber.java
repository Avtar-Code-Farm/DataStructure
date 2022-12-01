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

        int[] nums = new int[] {3,1,1,2,5,1,1,1,1,1};
        int res = maxSubArrayLen(target, nums);
        System.out.println("max subarray size " + res + " with sum " + target);
    }



    //1. Use two pointers: start and end to represent a window.
    //2. Move start to find a valid window i.e, target == sum
    //3. When a valid window is found check its size and update the max
    public static int maxSubArrayLen(int target, int[] nums ) {
        int max = Integer.MIN_VALUE;
        int start = 0;
        int sum  = 0;

        for(int end = 0; end < nums.length; end++) {
            sum += nums[end];


            if(sum == target) {
                max = Math.max(max, end - start + 1);
            }

            while(sum > target) {
                sum -= nums[start];
                start++;
            }
        }

        return max == Integer.MIN_VALUE ? 0 : max;
    }
}
