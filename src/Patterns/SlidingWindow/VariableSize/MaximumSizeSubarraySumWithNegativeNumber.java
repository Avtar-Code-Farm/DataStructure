package Patterns.SlidingWindow.VariableSize;

import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubarraySumWithNegativeNumber {
    public static void main(String[] args) {
        int target = 3;

        int[] nums = new int[] {5,1,2,-3,3,-1,2,4};
        int res = maxSubArrayWithNegativeNumberLen(target, nums);
        System.out.println("max subarray size " + res + " with sum " + target);
    }

    private static int maxSubArrayWithNegativeNumberLen(int k, int[] nums) {
        if (nums == null || nums.length == 0)   return 0;
        // key: prefix sum, value: right index of the leftmost subarray
        // that has this prefix sum value
        Map<Integer, Integer> counter = new HashMap<>();
        int maxLen = Integer.MIN_VALUE;
        int sum = 0;    // current running sum

        // iterate through the array only once is enough
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            // check if sum is matching up with k
            if(sum == k) {
                maxLen = 1;
            }

            // see if there is a prevuous array whose prefix sum is (sum - k)
            int target = sum - k;
            if (counter.containsKey(target)) {
                maxLen = Math.max(maxLen, i - counter.get(target));
            }
            // put current index into map if this is the first time we see the
            // current prefix sum value (which implies current index is leftmost)
            counter.putIfAbsent(sum, i);
        }
        // don't forget to check if there is such a subarray that meet the condition
        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;

    }
}
