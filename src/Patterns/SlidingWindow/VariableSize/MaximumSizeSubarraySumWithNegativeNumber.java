package Patterns.SlidingWindow.VariableSize;

import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubarraySumWithNegativeNumber {
    public static void main(String[] args) {
        int target = 3;

        int[] nums = new int[] {5,1,2,-3,3,-1,2,4};
        int res = maxSubArrayWithNegativeNumberLen(target, nums);
        System.out.println("max subarray size " + res + " with sum " + target);
        int res2 = getMaxLengthSubArrayWithKSum(nums, target);
    }



    public static int getMaxLengthSubArrayWithKSum(int[] nums, int k) {
        if(nums.length == 0) return 0;

        int start = 0;
        int max = Integer.MIN_VALUE;
        int curr_sum = 0;

        // map to hold curr_sum - k value and its index
        Map<Integer, Integer> map = new HashMap<>();

        for(int end = 0; end < nums.length; end++) {
            // keep adding values of the array into the curr_sum
            curr_sum += nums[end];

            // it means we got the sum from the index 0 and that is the max sum for given time.
            if(curr_sum == k) max = end + 1;

            // we will use the diff to find the index in the map if it exists. if it exists it means sum K also exists.
            int diff = curr_sum - k;

            if(map.containsKey(diff)) {
                // it gives us the index of currsum-k
                int index = map.get(diff);
                max = Math.max(max, end - index);

                // printing values.
                System.out.println("New ");
                for(int p = index + 1; p <= end; p++) {
                    System.out.print( " " + nums[p] + " ");
                }
            }

            map.putIfAbsent(curr_sum, end);
        }

        return max;
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
